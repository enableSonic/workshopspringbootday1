package com.example.day1.user;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserResponse get(int id) {
        if(id == 2){
            throw  new UserNotFouneException(new StringBuilder().append("User id not found =").append(id).toString());
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(1);
        userResponse.setFname("FName");
        userResponse.setLname("LName");
        return  userResponse;
    }
}
