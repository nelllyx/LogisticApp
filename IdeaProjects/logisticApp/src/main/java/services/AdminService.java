package services;

import dtos.requests.RegisterUserRequest;
import dtos.response.RegisterUserResponse;

public interface AdminService {

    RegisterUserResponse adminSignup(RegisterUserRequest registerUserRequest);
}
