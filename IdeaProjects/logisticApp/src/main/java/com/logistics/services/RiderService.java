package com.logistics.services;

import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;

public interface RiderService {
    RegisterUserResponse riderSignUp(RegisterUserRequest registerUserRequest);
    void deleteAll();
}
