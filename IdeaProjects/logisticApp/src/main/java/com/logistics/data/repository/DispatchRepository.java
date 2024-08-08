package com.logistics.data.repository;

import com.logistics.data.model.Dispatch;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DispatchRepository extends MongoRepository<Dispatch, String> {
}
