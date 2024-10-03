package com.example.day1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse get(int id) {

        Optional<MyUser> result = userRepository.findById((long)id);
        if(result.isEmpty()){
            throw  new UserNotFouneException(new StringBuilder().append("User id not found =").append(id).toString());
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(id);
        userResponse.setFname(result.get().getFirstName());
        userResponse.setLname(result.get().getLastName());
        return  userResponse;
    }
}
