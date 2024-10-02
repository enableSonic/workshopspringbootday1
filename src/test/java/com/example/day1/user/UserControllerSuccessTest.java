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

    @Test
    @DisplayName("Success with get user by id =1")
    void getById() {
        // Act
        UserResponse result = restTemplate.getForObject("/user/1", UserResponse.class);
        // Assert
        assertEquals(1, result.getId());
        assertEquals("FName", result.getFname());
        assertEquals("LName", result.getLname());
    }
}