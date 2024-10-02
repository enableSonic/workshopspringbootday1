package com.example.day1.user;

import com.example.day1.global.ErrorResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerFailureTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Failure with get user by id = 2 => 404 User Not Found")
    void case01() {
        // Act
        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/user/2", ErrorResponse.class);
        // Assert
        assertEquals(404, result.getStatusCode().value());
        assertEquals("User Not Found", result.getBody().getMessage());
    }

    @Test
    @DisplayName("Failure with get user by id = 2 => 400 Error input type mismatch ")
    void case02() {
        // Act
        ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/user/2ddd", ErrorResponse.class);
        // Assert
        assertEquals(400, result.getStatusCode().value());
        //assertEquals("Failed to convert value of type 'java.lang.String' to required type 'int'; For input string: \"2ddd", result.getBody().getMessage());
    }

}