package dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class RegisterUserRequest {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;

}
