package com.logistics.services;

import com.logistics.dtos.requests.PayStackPaymentRequest;

import com.logistics.dtos.response.PayStackPaymentResponse;
import com.logistics.dtos.response.VerifyResponse;


public interface PayStackService {
   PayStackPaymentResponse initializePayment(PayStackPaymentRequest paymentRequest);
   VerifyResponse<?> verifyPayment(String reference);
   String checkPaymentStatus(String reference);
   //void savePayment(String reference);
}
