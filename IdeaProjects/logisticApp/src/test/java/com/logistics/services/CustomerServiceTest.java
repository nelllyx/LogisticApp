package com.logistics.services;

import com.logistics.LogisticMain;
import com.logistics.data.model.Dispatch;
import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.LoginResponse;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.RegisterUserResponse;

import com.logistics.exception.LogisticAppException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.logistics.data.model.Location.MAINLAND;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
        //(classes = LogisticMain.class)

class CustomerServiceTest {
 @Autowired
    private CustomerService customerService;

    @Autowired
    private  AuthenticationService correct;


//    @BeforeEach
//    public void setUp(){
//        customerService.deleteAll();
//    }
//


    @Test
    public  void testThatCustomerCanRegister(){
        RegisterUserRequest newUser = new RegisterUserRequest();

        newUser.setFirstName("Nelson");
        newUser.setLastName("Akewe");
        newUser.setAddress("unit 9, jordan brookes estate osapa");
        newUser.setEmail("nelsonakewe0@gmail.com");
        newUser.setPhoneNumber("08114340839");
        newUser.setUserName("nellly");
        newUser.setPassword("1234");
        RegisterUserResponse response = customerService.registerUser(newUser);
        assertThat(response).isNotNull();
    }

    @Test
    public void testThat_thereAreNoCustomerWithSameUserName(){
        RegisterUserRequest firstUser = new RegisterUserRequest();
        firstUser.setFirstName("Kent");
        firstUser.setLastName("Okoro");
        firstUser.setAddress("unit 9, jordan brookes estate osapa");
        firstUser.setEmail("kentOkoro75@gmail.com");
        firstUser.setPhoneNumber("08114340839");
        firstUser.setUserName("kentBenk");
        firstUser.setPassword("1234");
       customerService.registerUser(firstUser);

       RegisterUserRequest newUser = new RegisterUserRequest();
        newUser.setFirstName("Josh");
        newUser.setLastName("Okoro");
        newUser.setAddress("mushin olosha");
        newUser.setEmail("bigJosh75@gmail.com");
        newUser.setPhoneNumber("08034643645");
        newUser.setUserName("Benk");
        newUser.setPassword("23444");
        assertThrows(LogisticAppException.class, ()->customerService.registerUser(newUser));
    }

    @Test

    public void testThatCustomerCanLogin(){
        RegisterUserRequest newUser = new RegisterUserRequest();
        newUser.setFirstName("Josh");
        newUser.setLastName("Okoro");
        newUser.setAddress("mushin olosha");
        newUser.setEmail("bigJosh75@gmail.com");
        newUser.setPhoneNumber("08034643645");
        newUser.setUserName("kentBenk");
        newUser.setPassword("23444");
        customerService.registerUser(newUser);

        LoginRequest ll = new LoginRequest();
        ll.setUsername("kentBenk");
        ll.setPassword("23444");
        LoginResponse response = correct.authenticationLogin(ll);
        assertThat(response.getMessage() ).containsIgnoringCase("login successful");
    }

    @Test

    public  void testThatCustomerCanSendAPackage(){
        RegisterUserRequest firstUser = new RegisterUserRequest();
        firstUser.setFirstName("Kent");
        firstUser.setLastName("Okoro");
        firstUser.setAddress("unit 9, jordan brookes estate osapa");
        firstUser.setEmail("kentOkoro75@gmail.com");
        firstUser.setPhoneNumber("08114340839");
        firstUser.setUserName("biggie");
        firstUser.setPassword("1234");
        customerService.registerUser(firstUser);

        PackageRequest parcel = new PackageRequest();
        parcel.setSenderUsername(firstUser.getUserName());
        parcel.setPackageName("Iphone");
        parcel.setReceiverName("Ayodeji");
        parcel.setPickUpAddress("unit 9, jordan brookes estate osapa");
        parcel.setDeliveryAddress("mushin olosha");
        parcel.setReceiverPhone("090624440001");
        parcel.setDeliveryLocation(MAINLAND);
       PackageResponse response =  customerService.sendPackage(parcel);
        assertThat(response.getMessage() ).containsIgnoringCase("Your package has been registered and would be valid once you make payment");
        assertThat(response).isNotNull();
    }
    }

