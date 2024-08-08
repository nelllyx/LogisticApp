package com.logistics.utils;

import com.logistics.data.model.Dispatch;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.RegisterUserRequest;

public class ClientPackage {
    public static Dispatch userPackage(PackageRequest senderPackage){
        Dispatch parcel = new Dispatch();
        parcel.setSenderUsername(senderPackage.getSenderUsername());
        parcel.setDeliveryLocation(senderPackage.getDeliveryLocation());
        parcel.setPackageName(senderPackage.getPackageName());
        parcel.setPickUpAddress(senderPackage.getPickUpAddress());
        parcel.setReceiverName(senderPackage.getReceiverName());
        parcel.setDeliveryAddress(senderPackage.getDeliveryAddress());
        parcel.setReceiverName(senderPackage.getReceiverName());
        parcel.setReceiverPhone(senderPackage.getReceiverPhone());

        return parcel;
    }
}
