package com.example.day1.user;

import com.example.day1.hello.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public UserResponse getById(@PathVariable int id){

        if(id == 2){
            throw  new UserNotFouneException(new StringBuilder().append("User id not found =").append(id).toString());
        }

        UserResponse userResponse = new UserResponse();
        userResponse.setId(1);
        userResponse.setFname("FName");
        userResponse.setLname("LName");
        return userResponse;
    }




}
