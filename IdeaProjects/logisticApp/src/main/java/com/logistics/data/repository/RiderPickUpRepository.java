package com.logistics.data.repository;

import com.logistics.data.model.RiderPickUp;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiderPickUpRepository extends MongoRepository<RiderPickUp, String> {
}
