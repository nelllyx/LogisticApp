package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.PayStackPayment;
import com.logistics.data.model.UserRole;
import com.logistics.data.repository.DispatchRepository;
import com.logistics.data.repository.PayStackPaymentRepository;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.PaymentResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.CustomerNotFoundException;
import com.logistics.exception.LogisticAppException;
import lombok.RequiredArgsConstructor;

import com.logistics.data.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.logistics.data.model.UserRole.ADMIN;
import static com.logistics.data.model.UserRole.CUSTOMER;
import static com.logistics.utils.ClientPackage.userPackage;
import static com.logistics.utils.Mapper.map;



@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final UserRepository customer;

    private final PayStackPaymentRepository payStackPaymentRepository;

    private final DispatchRepository dispatchRepository;

    private static final int ISLANDPAYMENT = 3000;

    private static final int MAINLANDPAYMENT = 4500;


    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
            User user = map(registerUserRequest);
        if (customer.existsByUsername(registerUserRequest.getUserName())) {
            throw new LogisticAppException("Username already exist ");
        }  else {
            user.setRole(CUSTOMER);
            customer.save(user);

            RegisterUserResponse registerUserResponse = new RegisterUserResponse();
            registerUserResponse.setMessage("welcome");
            return registerUserResponse;
        }
    }

        public PackageResponse sendPackage (PackageRequest customerPackage){
            Dispatch parcel = userPackage(customerPackage);
            String userName = parcel.getSenderUsername();
            if(customer.existsByUsername(userName)){
                //customerPackage.getDeliveryLocation()
              //  User foundUser = verifyUser(customerPackage.getSenderUsername());
                if(parcel.getDeliveryLocation().equalsIgnoreCase("ISLAND")){
                    parcel.setAmount(ISLANDPAYMENT);
                } else if (parcel.getDeliveryLocation().equalsIgnoreCase("MAINLAND")) {
                    parcel.setAmount(MAINLANDPAYMENT);
                }

                //parcel.setUser(foundUser);

                parcel=dispatchRepository.save(parcel);
                String userId =  parcel.getId();
                PayStackPaymentRequest users = new PayStackPaymentRequest();
                users.setDispatchId(userId);
                PackageResponse parcelResponse = getPackageResponse(parcel);
                return parcelResponse;
            }
            else {
                throw new LogisticAppException("Username does not exist ");
            }



        }




    private static PackageResponse getPackageResponse(Dispatch parcel) {
        double deliveryFee = parcel.getAmount();
        String parcelId = parcel.getId();
        return new PackageResponse(parcelId,deliveryFee);

    }


    public void savePayment(PayStackPaymentRequest request) {
     Dispatch user = dispatchRepository.findDispatchBySenderUsername(request.getSenderUsername());

            user.setHasPaid(true);
//        PayStackPayment payment = new PayStackPayment();
//
//        PaymentResponse response = new PaymentResponse();
//        response.setMessage("Payment successful");
//        payment.setAmount(paymentRequest.getAmount());
//        payment.setSenderUsername(paymentRequest.getSenderUsername());
//        payment.setDispatchId(paymentRequest.getDispatchId());
//        payment.setHasPaid(true);
//        //payment.setUser(foundCustomer);
//        payStackPaymentRepository.save(payment);





        }

    @Override
    public User verifyUser(String username) {
        return customer.findByUsername(username)
                .orElseThrow(()-> new LogisticAppException("User name not found"));
    }


    @Override
    public void deleteAll() {
        customer.deleteAll();
    }


}
