package com.logistics.config;


import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class PayStackConfig {

   @Value("${paystack.api.key}")

    private  String payStackApikey;

   @Value("${paystack.url}")

    private  String payStackURL;

}
