package utils;

import data.model.User;
import dtos.requests.RegisterUserRequest;


public class Mapper {
    public static User map(RegisterUserRequest registerUserRequest) {
      User register = new User();
      register.setFirstname(registerUserRequest.getFirstName());
      register.setLastname(registerUserRequest.getLastName());
      register.setEmail(registerUserRequest.getEmail());
      register.setAddress(registerUserRequest.getAddress());
      register.setCity(registerUserRequest.getCity());
      register.setPhone(registerUserRequest.getPhoneNumber());
      register.setUsername(registerUserRequest.getUserName());
      register.setPassword(registerUserRequest.getPassword());


      return register;
    }
}
