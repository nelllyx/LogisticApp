package com.logistics.web;

import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.ApiResponse;
import com.logistics.dtos.response.LoginResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.services.AuthenticationServiceImpl;
import com.logistics.services.RiderServiceImpl;
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
@RequestMapping("/rider")

public class RiderController {
        private final RiderServiceImpl rider;
        private  final AuthenticationServiceImpl riderLogin;


        @PostMapping("rider-registration")

        public ResponseEntity<?> riderRegistration(@RequestBody RegisterUserRequest registerUserRequest){
            try{
                RegisterUserResponse response = rider.riderSignUp(registerUserRequest);
                return new ResponseEntity<>(new ApiResponse(true,response),OK);
            }catch(Exception message){
                return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
            }
        }

    @PostMapping("rider-login")

    public ResponseEntity<?> riderLogin(@RequestBody LoginRequest loginRiderRequest){
        try{
            LoginResponse response = riderLogin.authenticationLogin(loginRiderRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch(Exception message){
            return ResponseEntity.badRequest().body(message.getMessage());
        }
    }





}
