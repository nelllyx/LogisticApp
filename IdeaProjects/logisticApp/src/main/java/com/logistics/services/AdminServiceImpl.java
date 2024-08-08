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
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserRepository admin;

    @Override
    public RegisterUserResponse adminSignup(RegisterUserRequest registerUserRequest){
       if(admin.existsByUsername(registerUserRequest.getUserName())){
           throw new LogisticAppException("Username already exist ");
       }else{
           User user = map(registerUserRequest);
           user.setRole(UserRole.ADMIN);
           admin.save(user);

           RegisterUserResponse registerUserResponse = new RegisterUserResponse();
           registerUserResponse.setMessage("Registration successful");
           return registerUserResponse;
       }

    }

    @Override
    public void deleteAll() {
        admin.deleteAll();
    }


}
