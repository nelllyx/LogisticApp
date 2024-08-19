package com.logistics.services;


import com.logistics.data.model.User;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.LoginResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.LogisticAppException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private  UserRepository login;
    private  CustomerService customerService;


    @Override
    public RegisterUserResponse authenticationRegister(RegisterUserRequest userRegister) {
        RegisterUserResponse response = new RegisterUserResponse();

        boolean isUser = login.existsByUsername(userRegister.getUserName());
        if (isUser){
            throw new LogisticAppException("Username already exist");
        }
         response.setMessage("Registered Successfully");
         return response;
    }
    public LoginResponse authenticationLogin(LoginRequest userLogin) {
        User user = customerService.verifyUser(userLogin.getUsername());
        if(!user.getPassword().equals(userLogin.getPassword()))throw new LogisticAppException("Wrong Credentials");
        return new LoginResponse("Login Successful");
    }
}
