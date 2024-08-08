package com.logistics.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@Document("dispatch")
public class Dispatch {
    private String id;
    private String senderUsername;
    private String pickUpAddress;
    private String deliveryAddress;
    private String packageName;
    private String receiverName;
    private String receiverPhone;
    private Location deliveryLocation;

}


