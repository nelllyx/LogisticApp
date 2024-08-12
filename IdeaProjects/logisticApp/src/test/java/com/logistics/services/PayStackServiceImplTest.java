package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.User;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.PayStackPaymentRequest;
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

//        @Test
//        public  void paymentServiceTest() {
//            PayStackPaymentRequest request = new PayStackPaymentRequest();
//
//            request.setAmount(]);
//            request.setEmail("example7@gmail.com");
//            request.setSenderUsername(request.getSenderUsername());
//            request.setDispatchId(request.getDispatchId());
//
//            PayStackPaymentResponse response= pay.initializePayment(request);
//                System.out.print(response);
//                assertThat(response).isNotNull();
//
//        }
}