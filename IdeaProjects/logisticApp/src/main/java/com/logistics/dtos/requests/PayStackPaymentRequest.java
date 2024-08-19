package com.logistics.dtos.requests;

import com.logistics.data.model.Location;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Setter
@Getter
public class PayStackPaymentRequest {
    private double amount;
    private String email;
    private String senderUsername;
    private String dispatchId;
    private String status;
}
