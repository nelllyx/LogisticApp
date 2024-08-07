package data.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

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
   private String city;
   private String firstname;
   private String lastname;

   private UserRole role;

}
