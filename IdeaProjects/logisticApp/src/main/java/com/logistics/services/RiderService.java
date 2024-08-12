package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;

import java.util.List;

public interface RiderService {
    RegisterUserResponse riderSignUp(RegisterUserRequest registerUserRequest);
    void deleteAll();
    List<Dispatch> findAllOrders();
}
