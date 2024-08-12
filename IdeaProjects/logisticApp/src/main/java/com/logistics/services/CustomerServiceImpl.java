package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.PayStackPayment;
import com.logistics.data.model.UserRole;
import com.logistics.data.repository.DispatchRepository;
import com.logistics.data.repository.PayStackPaymentRepository;
import com.logistics.data.repository.PaymentRepository;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.PaymentResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.LogisticAppException;
import lombok.RequiredArgsConstructor;

import com.logistics.data.model.User;
import org.springframework.stereotype.Service;

import static com.logistics.data.model.UserRole.CUSTOMER;
import static com.logistics.utils.ClientPackage.userPackage;
import static com.logistics.utils.Mapper.map;



@Service
@RequiredArgsConstructor
public class
CustomerServiceImpl implements CustomerService {

    private final UserRepository customer;

    //private final PaymentRepository pay;

    private final PayStackPaymentRepository payStackPaymentRepository;

    private final DispatchRepository dispatchRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
            User user = map(registerUserRequest);
        if (customer.existsByUsername(registerUserRequest.getUserName()) && user.getRole() != CUSTOMER) {
            throw new LogisticAppException("Username already exist ");
        } else {
            user.setRole(CUSTOMER);
            customer.save(user);

            RegisterUserResponse registerUserResponse = new RegisterUserResponse();
            registerUserResponse.setMessage("welcome");
            return registerUserResponse;
        }
    }

        public PackageResponse sendPackage (PackageRequest customerPackage){
            Dispatch parcel = userPackage(customerPackage);
            if(customer.existsByUsername(parcel.getSenderUsername())){
                if(parcel.getDeliveryLocation().equalsIgnoreCase("ISLAND")){
                    parcel.setAmount(3000);
                } else if (parcel.getDeliveryLocation().equalsIgnoreCase("MAINLAND")) {
                    parcel.setAmount(4500);
                }
                parcel=dispatchRepository.save(parcel);
               String userId =  parcel.getId();
                PayStackPaymentRequest users = new PayStackPaymentRequest();
                users.setDispatchId(userId);
                PackageResponse parcelResponse = getPackageResponse(parcel);
                return parcelResponse;

            }else {
                throw new LogisticAppException("Username does not exist ");
            }



        }

    private static PackageResponse getPackageResponse(Dispatch parcel) {
        PackageResponse response = new PackageResponse();
        response.setMessage("Your package has been registered and would be valid once you make payment. DELIVERY FEE IS:" + parcel.getAmount());
        return response;
    }


    public void savePayment(PayStackPaymentRequest paymentRequest) {
        PayStackPayment payment = new PayStackPayment();
        Dispatch dispatch = new Dispatch();
        payment.setAmount(dispatch.getAmount());
        payment.setSenderUsername(paymentRequest.getSenderUsername());
        payment.setDispatchId(paymentRequest.getDispatchId());
        payStackPaymentRepository.save(payment);

        PaymentResponse response = new PaymentResponse();
        response.setMessage("Payment successful");

    }
    @Override
    public void deleteAll() {
        customer.deleteAll();
    }
}
