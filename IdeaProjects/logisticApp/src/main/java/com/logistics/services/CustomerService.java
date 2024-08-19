package com.logistics.services;

import com.logistics.data.model.PayStackPayment;
import com.logistics.data.model.User;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    PackageResponse sendPackage(PackageRequest packageRequest);
    void savePayment(PayStackPaymentRequest paymentRequest);
    User verifyUser(String username);
    void deleteAll();
}
