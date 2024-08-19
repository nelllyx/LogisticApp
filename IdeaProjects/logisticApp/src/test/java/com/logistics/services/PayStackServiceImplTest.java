package com.logistics.services;

import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.PayStackPaymentResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static com.logistics.utils.ClientPackage.userPackage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PayStackServiceImplTest {
    @Autowired
    PayStackServiceImpl pay;
    @Autowired
    private CustomerService customerService;

        @Test
        public  void paymentServiceTest() {
            PackageResponse respond = new PackageResponse();
            PackageRequest parcel = new PackageRequest();
            PayStackPaymentRequest request = new PayStackPaymentRequest();
            RegisterUserRequest firstUser = new RegisterUserRequest();
            firstUser.setFirstName("tomilade");
            firstUser.setLastName("oyebola");
            firstUser.setAddress("unit 3, jordan brookes estate osapa");
            firstUser.setEmail("OyebolaT75@gmail.com");
            firstUser.setPhoneNumber("08114340839");
            firstUser.setUserName("bigT");
            firstUser.setPassword("1234");
            customerService.registerUser(firstUser);
            parcel.setSenderUsername(firstUser.getUserName());
            parcel.setPackageName("Iphone");
            parcel.setReceiverName("Ayodeji");
            parcel.setPickUpAddress("unit 9, jordan brookes estate osapa");
            parcel.setDeliveryAddress("mushin olosha");
            parcel.setReceiverPhone("090624440001");
            parcel.setDeliveryLocation("MAINLAND");
            customerService.sendPackage(parcel);

            request.setAmount(4000);
            request.setEmail("example7@gmail.com");
            request.setSenderUsername(parcel.getSenderUsername());
            request.setDispatchId(respond.getDispatchID());

            PayStackPaymentResponse response= pay.initializePayment(request);
                System.out.print(response);
                assertThat(response).isNotNull();
        }

        @Test void test_Verify_Payment(){
            String status = pay.checkPaymentStatus("r44wg9m4gx");
            System.out.println(status);
            //https://checkout.paystack.com/v5ek8yw682vvmls
        }
}