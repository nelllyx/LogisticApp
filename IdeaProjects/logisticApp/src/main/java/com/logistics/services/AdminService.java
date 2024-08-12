package com.logistics.services;

import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;

public interface AdminService {

    RegisterUserResponse adminSignup(RegisterUserRequest registerUserRequest);


    void deleteAll();
}
