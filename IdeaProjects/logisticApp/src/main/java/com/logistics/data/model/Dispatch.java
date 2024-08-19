package com.logistics.data.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document("dispatch")
@ToString
public class Dispatch {
    private String id;
    private String senderUsername;
    private String pickUpAddress;
    private String deliveryAddress;
    private String packageName;
    private String receiverName;
    private String receiverPhone;
    private String deliveryLocation;
    private double amount;
    private  boolean hasPaid;
    //private User user;
}


