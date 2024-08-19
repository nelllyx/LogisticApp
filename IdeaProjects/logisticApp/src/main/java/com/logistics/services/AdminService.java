package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.PayStackPayment;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.DispatchNotFoundException;

public interface AdminService {

    RegisterUserResponse adminSignup(RegisterUserRequest registerUserRequest);
    Dispatch findDispatchById(String id) throws DispatchNotFoundException;
    PayStackPayment checkPayment(String username);
    void deleteAll();
}
