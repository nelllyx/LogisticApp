package com.logistics.data.repository;

import com.logistics.data.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public interface UserRepository extends MongoRepository<User, String> {
   boolean existsByUsername(String username);
   User findByUsername(String username);

}
