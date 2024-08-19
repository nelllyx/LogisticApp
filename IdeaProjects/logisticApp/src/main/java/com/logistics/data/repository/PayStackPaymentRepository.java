package com.logistics.data.repository;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.PayStackPayment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayStackPaymentRepository extends MongoRepository<PayStackPayment, String> {
        PayStackPayment findPayStackPaymentBySenderUsername(String username);
}
