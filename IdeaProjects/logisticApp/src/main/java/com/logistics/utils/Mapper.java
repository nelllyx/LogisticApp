package com.logistics.utils;

import com.logistics.data.model.User;
import com.logistics.dtos.requests.RegisterUserRequest;


public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
      User register = new User();
      register.setFirstname(registerUserRequest.getFirstName());
      register.setLastname(registerUserRequest.getLastName());
      register.setEmail(registerUserRequest.getEmail());
      register.setAddress(registerUserRequest.getAddress());
      register.setPhone(registerUserRequest.getPhoneNumber());
      register.setUsername(registerUserRequest.getUserName());
      register.setPassword(registerUserRequest.getPassword());


      return register;
    }
}
