package com.example.day1.user;

import com.example.day1.hello.HelloResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerSuccessTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Success with get user by id =1")
    void getById() {
        MyUser myUser = new MyUser();
        myUser.setId(1L);
        myUser.setFirstName("FName");
        myUser.setLastName("LName");
        myUser.setAge(10);
        userRepository.saveAndFlush(myUser);
        // Act
        UserResponse result = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("FName", result.getFname());
        assertEquals("LName", result.getLname());
    }

    @Test
    @DisplayName("createNewUser Success")
    void createNewUserSuccess(){
       CreateUserRequest createUserRequest = new CreateUserRequest();
       createUserRequest.setFname("FName");
       createUserRequest.setLname("LName");
       createUserRequest.setAge(10);

        UserResponse result = restTemplate.postForObject("/user",createUserRequest, UserResponse.class);

        assertEquals(10, result.getAge());
        assertEquals("FName", result.getFname());
        assertEquals("LName", result.getLname());

    }

}