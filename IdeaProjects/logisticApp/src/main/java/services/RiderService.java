package services;

import dtos.requests.RegisterUserRequest;
import dtos.response.RegisterUserResponse;

public interface RiderService {
    RegisterUserResponse riderSignUp(RegisterUserRequest registerUserRequest);
}
