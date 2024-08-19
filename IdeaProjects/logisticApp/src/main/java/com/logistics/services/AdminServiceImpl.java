package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.PayStackPayment;
import com.logistics.data.model.User;
import com.logistics.data.model.UserRole;
import com.logistics.data.repository.DispatchRepository;
import com.logistics.data.repository.PayStackPaymentRepository;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.DispatchNotFoundException;
import com.logistics.exception.LogisticAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.logistics.utils.Mapper.map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository admin;
    @Autowired
    private DispatchRepository dispatchRepository;

    @Autowired
    private PayStackPaymentRepository pay;

    @Autowired
    private CustomerServiceImpl customer;

    @Override
    public RegisterUserResponse adminSignup(RegisterUserRequest registerUserRequest) {
        if (admin.existsByUsername(registerUserRequest.getUserName())) {
            throw new LogisticAppException("Username already exist ");
        } else {
            User user = map(registerUserRequest);
            user.setRole(UserRole.ADMIN);
            admin.save(user);

            RegisterUserResponse registerUserResponse = new RegisterUserResponse();
            registerUserResponse.setMessage("Registration successful");
            return registerUserResponse;
        }

    }

    @Override
    public Dispatch findDispatchById(String id) throws DispatchNotFoundException {

        return dispatchRepository.findById(id).orElseThrow(() -> new DispatchNotFoundException("dispatch not found"));

        //pay.findPayStackPaymentBySenderUsername()
    }


    @Override
    public void deleteAll() {
        admin.deleteAll();
    }

    public PayStackPayment checkPayment(String username){
//    User user = customer.verifyUser(username);
//        List<PayStackPayment> payments = user.getPayments();
    return pay.findPayStackPaymentBySenderUsername(username);
    }
}
