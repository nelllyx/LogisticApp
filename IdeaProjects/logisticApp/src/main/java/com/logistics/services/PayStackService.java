package com.logistics.services;

import com.logistics.dtos.requests.PayStackPaymentRequest;

import com.logistics.dtos.response.PayStackPaymentResponse;


public interface PayStackService {
   PayStackPaymentResponse initializePayment(PayStackPaymentRequest paymentRequest);

}
