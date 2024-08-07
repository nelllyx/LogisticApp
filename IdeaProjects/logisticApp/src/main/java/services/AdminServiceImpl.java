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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private
    UserRepository admin;

    @Override
    public RegisterUserResponse adminSignup(RegisterUserRequest registerUserRequest){
        User user = map(registerUserRequest);
        user.setRole(UserRole.ADMIN);
        admin.save(user);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("Registration successful");
        return registerUserResponse;
    }


}
