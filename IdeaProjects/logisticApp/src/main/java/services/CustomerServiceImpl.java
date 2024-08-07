package services;

import data.model.UserRole;
import data.repository.UserRepository;
import dtos.requests.RegisterUserRequest;
import dtos.response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import data.model.User;

import static utils.Mapper.map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
       User user = map(registerUserRequest);
       user.setRole(UserRole.CUSTOMER);
       userRepository.save(user);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("welcome");
        return registerUserResponse;
    }
}
