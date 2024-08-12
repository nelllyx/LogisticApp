package com.logistics.dtos.requests;

import com.logistics.data.model.Location;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PackageRequest {
    private String senderUsername;
    private String pickUpAddress;
    private String deliveryAddress;
    private String packageName;
    private String receiverName;
    private String receiverPhone;
    private String deliveryLocation;

}
