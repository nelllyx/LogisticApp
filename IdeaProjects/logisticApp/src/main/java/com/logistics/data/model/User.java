package com.logistics.data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter

@Document("users")

public class User {
   private String id;
   private String username;
   private String password;
   private String email;
   private String phone;
   private String address;
   private String firstname;
   private String lastname;
   private  Location location;
   private UserRole role;
   @DBRef
   private List<Dispatch> dispatches;
 //  @DBRef
  // private List<PayStackPayment> payments;


}
