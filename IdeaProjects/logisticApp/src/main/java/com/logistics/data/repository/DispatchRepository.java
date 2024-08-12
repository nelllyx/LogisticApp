package com.logistics.data.repository;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispatchRepository extends MongoRepository<Dispatch, String> {
Dispatch findByDeliveryLocation(String location);
Dispatch findDispatchBySenderUsername(String username);
}
