package com.logistics.data.repository;

import com.logistics.data.model.User;
import com.logistics.data.model.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
   boolean existsByUsername(String username);
   User findByUsername(String username);


}
