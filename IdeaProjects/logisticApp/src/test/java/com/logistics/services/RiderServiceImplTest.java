package com.logistics.services;

import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.RegisterUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class RiderServiceImplTest {
@Autowired
    private RiderService rider;

    @Autowired
    private  AuthenticationService correct;
    @BeforeEach
    public void setUp(){
        rider.deleteAll();
    }



    @Test
    public  void testThatRiderCanRegister(){
    RegisterUserRequest newRider = new RegisterUserRequest();
    newRider.setFirstName("Josh");
    newRider.setLastName("Sk");
    newRider.setAddress("Abraham adesanaya, ajah");
    newRider.setEmail("jjc12@gmail.com");
    newRider.setPhoneNumber("08114340839");
    newRider.setUserName("nellly");
    newRider.setPassword("1234");
    RegisterUserResponse response = rider.riderSignUp(newRider);
    assertThat(response).isNotNull();
}

}