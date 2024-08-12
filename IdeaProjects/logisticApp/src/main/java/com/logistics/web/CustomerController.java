package com.logistics.web;

import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.*;
import com.logistics.services.AuthenticationServiceImpl;
import com.logistics.services.CustomerServiceImpl;
import com.logistics.services.PayStackServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class CustomerController {
    private final CustomerServiceImpl users;
    private  final AuthenticationServiceImpl customerLogin;
    private final PayStackServiceImpl payment;


    @PostMapping("user-registration")
    public ResponseEntity<?> userRegistration(@RequestBody RegisterUserRequest registerUserRequest){
        try {
            RegisterUserResponse response = users.registerUser(registerUserRequest);
            return  new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
        }


    }

    @PostMapping("customer-login")

    public ResponseEntity<?> customerLogin(@RequestBody LoginRequest loginCustomerRequest){
        try{
            LoginResponse response = customerLogin.authenticationLogin(loginCustomerRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch(Exception message){
            return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
        }
    }

    @PostMapping("send-package")

    public  ResponseEntity<?> sendPackage(@RequestBody PackageRequest packageRequest){
        try{
            PackageResponse response = users.sendPackage(packageRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch(Exception message){
            return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
        }
    }

    @PostMapping("user-payment")
    public ResponseEntity<?> userPayment(@RequestBody PayStackPaymentRequest paymentRequest){
        try {
            paymentRequest.setAmount(paymentRequest.getAmount()*100);
            PayStackPaymentResponse response = payment.initializePayment(paymentRequest);
            return  new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch (Exception message){
            return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
        }


    }
}
