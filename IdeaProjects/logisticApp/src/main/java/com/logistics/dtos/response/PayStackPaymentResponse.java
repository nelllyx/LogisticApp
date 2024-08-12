package com.logistics.dtos.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.logistics.utils.PayStackData;
import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@ToString
@NoArgsConstructor
public class PayStackPaymentResponse {
    private  boolean status;
    private String message;
   @JsonProperty("data")
    private PayStackData userData;
}
