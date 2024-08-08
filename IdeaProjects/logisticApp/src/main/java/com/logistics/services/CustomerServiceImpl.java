package com.logistics.services;

import com.logistics.data.model.Dispatch;
import com.logistics.data.model.UserRole;
import com.logistics.data.repository.DispatchRepository;
import com.logistics.data.repository.UserRepository;
import com.logistics.dtos.requests.PackageRequest;
import com.logistics.dtos.requests.RegisterUserRequest;
import com.logistics.dtos.response.PackageResponse;
import com.logistics.dtos.response.RegisterUserResponse;
import com.logistics.exception.LogisticAppException;
import lombok.RequiredArgsConstructor;

import com.logistics.data.model.User;
import org.springframework.stereotype.Service;

import static com.logistics.utils.ClientPackage.userPackage;
import static com.logistics.utils.Mapper.map;



@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final UserRepository customer;
    private final DispatchRepository dispatchRepository;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {

        if (customer.existsByUsername(registerUserRequest.getUserName())) {
            throw new LogisticAppException("Username already exist ");
        } else {
            User user = map(registerUserRequest);
            user.setRole(UserRole.CUSTOMER);
            customer.save(user);

            RegisterUserResponse registerUserResponse = new RegisterUserResponse();
            registerUserResponse.setMessage("welcome");
            return registerUserResponse;
        }
    }

        public PackageResponse sendPackage (PackageRequest customerPackage){
            Dispatch parcel = userPackage(customerPackage);
            dispatchRepository.save(parcel);

            PackageResponse parcelResponse = new PackageResponse();
            parcelResponse.setMessage("Your package has been registered and would be valid once you make payment");
            return parcelResponse;
        }

    @Override
    public void deleteAll() {
        customer.deleteAll();
    }
}
