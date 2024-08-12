package com.logistics.data.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
@Setter
@Getter
@Document("payment")
public class PayStackPayment {
    private  String id;
    private String senderUsername;
    private String dispatchId;
    private double amount;
    private String trackingNumber;
}
