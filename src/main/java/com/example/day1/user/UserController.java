package com.example.day1.user;

import com.example.day1.hello.HelloResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public UserResponse getById(@PathVariable int id){
        return userService.get(id);
    }

    @PostMapping("/user")
    public UserResponse createNewUser(@RequestBody CreateUserRequest createUserRequest){

        UserResponse userResponse = new UserResponse();

        userResponse = userService.createNewUser(createUserRequest);

        userResponse.setFname(createUserRequest.getFname());
        userResponse.setLname(createUserRequest.getLname());
        userResponse.setAge(createUserRequest.getAge());
        return  userResponse;
    }


}
