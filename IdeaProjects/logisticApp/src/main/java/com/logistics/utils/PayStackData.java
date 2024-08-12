package com.logistics.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PayStackData {
    @JsonProperty("authorization_url")
    private String authorization;
    @JsonProperty("access_code")
    private String accessCode;
    private String reference;
}
