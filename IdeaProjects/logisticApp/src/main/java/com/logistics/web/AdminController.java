package com.logistics.web;

import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.ApiResponse;
import com.logistics.dtos.response.LoginResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.services.AdminService;
import com.logistics.services.AdminServiceImpl;
import com.logistics.services.AuthenticationServiceImpl;
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
@RequestMapping("/admin")
public class AdminController {
    private final AdminServiceImpl admin;
    private final AuthenticationServiceImpl adminLog;

    @PostMapping("admin-registration")

    public ResponseEntity<?> adminRegistration(@RequestBody RegisterUserRequest registerUserRequest){
        try{
            RegisterUserResponse response = admin.adminSignup(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch(Exception message){
            return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
        }
    }

    @PostMapping("/admin-login")

    public ResponseEntity<?> adminLogin(@RequestBody LoginRequest loginRiderRequest){
        try{
            LoginResponse response = adminLog.authenticationLogin(loginRiderRequest);
            return new ResponseEntity<>(new ApiResponse(true,response),OK);
        }catch(Exception message){
            return new ResponseEntity<>(new ApiResponse(false,message),BAD_REQUEST);
        }
    }
}
