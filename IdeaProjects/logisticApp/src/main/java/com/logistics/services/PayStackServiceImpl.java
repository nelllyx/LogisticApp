package com.logistics.services;

import com.logistics.config.PayStackConfig;
import com.logistics.data.model.PayStackPayment;
import com.logistics.data.repository.DispatchRepository;
import com.logistics.data.repository.PayStackPaymentRepository;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.PayStackPaymentRequest;
import com.logistics.dtos.response.PayStackPaymentResponse;
import com.logistics.dtos.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class PayStackServiceImpl implements PayStackService {

    private final PayStackConfig config;
    private final DispatchRepository dispatchRepository;
    private final UserRepository userRepository;
    private final PayStackPaymentRepository payStackPaymentRepository;
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

//        Payment payment = new Payment();
//        if(response.getBody()!=null){
//            User user=  userRepository.findByUsername(paymentRequest.getSenderUsername());
//           // payment.setDispatchId();
//
//         }
        return response.getBody();

    }


}
