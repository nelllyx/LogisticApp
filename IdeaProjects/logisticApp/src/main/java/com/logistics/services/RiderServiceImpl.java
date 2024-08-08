package com.logistics.services;

import com.logistics.data.model.User;
import com.logistics.data.model.UserRole;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.LogisticAppException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.logistics.utils.Mapper.map;
@Service
public class RiderServiceImpl implements RiderService {

    @Autowired
    private UserRepository rider;

    @Override

    public RegisterUserResponse riderSignUp(RegisterUserRequest registerUserRequest) {

        if (rider.existsByUsername(registerUserRequest.getUserName())) {
            throw new LogisticAppException("Username already exist ");
        } else {
            User user = map(registerUserRequest);
            user.setRole(UserRole.RIDER);
            rider.save(user);


            RegisterUserResponse registerUserResponse = new RegisterUserResponse();
            registerUserResponse.setMessage("Registration successful");
            return registerUserResponse;
        }
    }

    @Override
    public void deleteAll() {
        rider.deleteAll();
    }
}