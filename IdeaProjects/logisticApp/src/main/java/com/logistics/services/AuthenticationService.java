package com.logistics.services;

import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.LoginResponse;
import com.logistics.dtos.response.RegisterUserResponse;

public interface AuthenticationService {
    RegisterUserResponse authenticationRegister(RegisterUserRequest userRegister);
    LoginResponse authenticationLogin(LoginRequest userLogin);
}
