package services;

import dtos.requests.LoginRequest;
import dtos.response.LoginResponse;

public interface AuthenticationService {

    LoginResponse authentication(LoginRequest userLogin);
}
