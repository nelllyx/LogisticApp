package com.logistics.services;

import com.logistics.config.PayStackConfig;
import com.logistics.data.model.Dispatch;
import com.logistics.data.model.PayStackPayment;
import com.logistics.data.repository.DispatchRepository;
import com.logistics.data.repository.PayStackPaymentRepository;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.response.PayStackPaymentResponse;
import com.logistics.dtos.response.PaymentResponse;
import com.logistics.dtos.response.VerifyResponse;
import com.logistics.exception.LogisticAppException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service

@RequiredArgsConstructor

public class PayStackServiceImpl implements PayStackService {
    private final PayStackConfig config;
    //private final PayStackPaymentRequest request = new PayStackPaymentRequest();
    private final DispatchRepository dispatchRepository;
//    private final UserRepository userRepository;
//    private final PayStackPaymentRepository payStackPaymentRepository;
   private final CustomerServiceImpl customerService;

    @Override
    public PayStackPaymentResponse initializePayment(PayStackPaymentRequest paymentRequest){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(config.getPayStackApikey());
        HttpEntity<PayStackPaymentRequest>payStackPaymentRequestHttpEntity = new HttpEntity<>(paymentRequest,headers);
        ResponseEntity<PayStackPaymentResponse> response = restTemplate.postForEntity(config.getPayStackURL(),payStackPaymentRequestHttpEntity,PayStackPaymentResponse.class);

        customerService.savePayment(paymentRequest);

        Dispatch user = dispatchRepository.findDispatchBySenderUsername(paymentRequest.getSenderUsername());
        user.setHasPaid(true);


        return response.getBody();

    }

    @Override
    public VerifyResponse<?> verifyPayment(String reference) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + config.getPayStackApikey());
        String url = config.getVerifyUrl() + reference;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, VerifyResponse.class).getBody();
    }

    @Override
    public String checkPaymentStatus(String reference) {
        VerifyResponse<?> res = verifyPayment(reference);
        String status = null;
        String responseString = res.getData().toString();
        Pattern pattern = Pattern.compile("status=(\\w+)");
        Matcher matcher = pattern.matcher(responseString);
        if (matcher.find()) {
            status = matcher.group(1);
        }

        return status;

    }

 //   @Override
//    public void savePayment(String reference) {
//        PayStackPaymentRequest request = new PayStackPaymentRequest();
//        String status = checkPaymentStatus(reference).toLowerCase();
//
//        if (status.equals("success")){
//            PaymentResponse response = new PaymentResponse();
//            response.setMessage("Payment successful");
//        customerService.savePayment(request);
//            }
//        else {
//            throw new LogisticAppException("oops!, payment was not successful");
//        }
//    }
}
