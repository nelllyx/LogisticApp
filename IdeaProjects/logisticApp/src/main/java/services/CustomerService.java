package services;

import dtos.requests.RegisterUserRequest;
import dtos.response.RegisterUserResponse;

public interface CustomerService {

    RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest);
}
