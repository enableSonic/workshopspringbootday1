package com.example.day1.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {


    @Autowired
    private  UserService userService;

    @Test
    @DisplayName("Success Case")
    void case01() {
        // Act
        UserResponse result =  userService.get(1);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("FName", result.getFname());
        assertEquals("LName", result.getLname());


    }

    @Test
    @DisplayName("404 Case")
    void case02(){

        Exception exception = assertThrows(UserNotFouneException.class, () -> userService.get(2));
        assertEquals("User id not found =2" ,exception.getMessage());

    }



}