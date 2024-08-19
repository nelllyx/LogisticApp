package com.logistics.dtos.response;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VerifyResponse <T>{
    private T data;
}
