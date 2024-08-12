package com.logistics.data.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Setter
@Getter
@Document("rider-pickup")

public class RiderPickUp {
    @Id
    private String Id;
    private String vehicleInfo;
    private String riderFirstName;
    private String riderLastName;
    private  boolean isAvailable;
    private boolean rideStatus;
    private List<Dispatch> packageInfo;
}
