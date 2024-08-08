package com.logistics.services;

import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public interface CustomerService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
    PackageResponse sendPackage(PackageRequest packageRequest);
    void deleteAll();
}
