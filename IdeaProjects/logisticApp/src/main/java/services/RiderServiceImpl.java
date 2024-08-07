package services;

import data.model.User;
import data.model.UserRole;
import data.repository.UserRepository;
import dtos.requests.RegisterUserRequest;
import dtos.response.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static utils.Mapper.map;
@Service
public class RiderServiceImpl implements RiderService{

    @Autowired
    private UserRepository rider;

    @Override

    public RegisterUserResponse riderSignUp(RegisterUserRequest registerUserRequest) {
        User user = map(registerUserRequest);
        user.setRole(UserRole.RIDER);
        rider.save(user);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("Registration successful");
        return registerUserResponse;
    }
}
