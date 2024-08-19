package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.User;
import com.logistics.dtos.requests.LoginRequest;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.LoginResponse;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.DispatchNotFoundException;
import com.logistics.exception.LogisticAppException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class AdminServiceImplTest {

    @Autowired
    private AdminService admin;
    @Autowired
    private  AuthenticationService correct;
    @Autowired
    private CustomerServiceImpl service;
    @BeforeEach
    public void setUp(){
        admin.deleteAll();
    }

    @Test
    public void testThatAdminCanRegister(){
        RegisterUserRequest user = new RegisterUserRequest();
        user.setFirstName("Kim");
        user.setLastName("tim");
        user.setAddress("312 herbert maccualay way sabo yaba");
        user.setEmail("lag@gmail.com");
        user.setPhoneNumber("098762445");
        user.setUserName("chiii");
        user.setPassword("1233");
        RegisterUserResponse response = admin.adminSignup(user);
        assertThat(response).isNotNull();

    }

    @Test
    public void testThatThere_AreNoAdminWith_SameUserName(){
        RegisterUserRequest user = new RegisterUserRequest();
        user.setFirstName("Kim");
        user.setLastName("tim");
        user.setAddress("312 herbert maccualay way sabo yaba");
        user.setEmail("lag@gmail.com");
        user.setPhoneNumber("098762445");
        user.setUserName("nellly");
        user.setPassword("1233");
        RegisterUserResponse m = admin.adminSignup(user);

        RegisterUserRequest secondAdmin = new RegisterUserRequest();
        secondAdmin.setFirstName("Nelson");
        secondAdmin.setLastName("Akewe");
        secondAdmin.setAddress("unit 9, jordan brookes estate osapa");
        secondAdmin.setEmail("nelsonakewe0@gmail.com");
        secondAdmin.setPhoneNumber("08114340839");
        secondAdmin.setUserName("nellly");
        secondAdmin.setPassword("1234");
        assertThrows(LogisticAppException.class, ()->admin.adminSignup(secondAdmin));
//        AuthenticationServiceImpl service = new AuthenticationServiceImpl();
//        assertThrows(LogisticAppException.class, ()-> service.authenticationRegister(d));

    }
    @Test
    public void testThatAdminCanLogin(){
        RegisterUserRequest user = new RegisterUserRequest();
        user.setFirstName("Kim");
        user.setLastName("tim");
        user.setAddress("312 herbert maccualay way sabo yaba");
        user.setEmail("lag@gmail.com");
        user.setPhoneNumber("098762445");
        user.setUserName("chiii");
        user.setPassword("1233");
        admin.adminSignup(user);
        LoginRequest ll = new LoginRequest();
        ll.setUsername("chiii");
        ll.setPassword("1233");
       LoginResponse response = correct.authenticationLogin(ll);
       assertThat(response.getMessage() ).containsIgnoringCase("login successful");
    }

    @Test void test_That_Dispatch_Exist() throws DispatchNotFoundException {

        RegisterUserRequest firstUser = new RegisterUserRequest();
        firstUser.setFirstName("Kent");
        firstUser.setLastName("Okoro");
        firstUser.setAddress("unit 9, jordan brookes estate osapa");
        firstUser.setEmail("kentOkoro75@gmail.com");
        firstUser.setPhoneNumber("08114340839");
        firstUser.setUserName("biggie");
        firstUser.setPassword("1234");
        service.registerUser(firstUser);


        PackageRequest parcel = new PackageRequest();
        parcel.setSenderUsername(firstUser.getUserName());
        parcel.setPackageName("Iphone");
        parcel.setReceiverName("Ayodeji");
        parcel.setPickUpAddress("unit 9, jordan brookes estate osapa");
        parcel.setDeliveryAddress(" olosha");
        parcel.setReceiverPhone("090624440001");
        parcel.setDeliveryLocation("MAINLAND");
       PackageResponse reply = service.sendPackage(parcel);

        Dispatch dispatch = admin.findDispatchById(reply.getDispatchID());
        String name = dispatch.getSenderUsername();
        String address = dispatch.getDeliveryAddress();
        System.out.println(dispatch);
        System.out.println(name);
        System.out.println(address);


    }

    @Test void testThatAdminCanConfirmPayment(){
        RegisterUserRequest firstUser = new RegisterUserRequest();
        firstUser.setFirstName("Kent");
        firstUser.setLastName("Okoro");
        firstUser.setAddress("unit 9, jordan brookes estate osapa");
        firstUser.setEmail("kentOkoro75@gmail.com");
        firstUser.setPhoneNumber("08114340839");
        firstUser.setUserName("biggie");
        firstUser.setPassword("1234");
        service.registerUser(firstUser);


        PackageRequest parcel = new PackageRequest();
        parcel.setSenderUsername(firstUser.getUserName());
        parcel.setPackageName("Iphone");
        parcel.setReceiverName("Ayodeji");
        parcel.setPickUpAddress("unit 9, jordan brookes estate osapa");
        parcel.setDeliveryAddress(" olosha");
        parcel.setReceiverPhone("090624440001");
        parcel.setDeliveryLocation("MAINLAND");
        service.sendPackage(parcel);

    }


}