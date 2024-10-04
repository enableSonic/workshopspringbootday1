package com.example.day1.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostGatewayTest {

    @Autowired
    PostGateway postGateway;

    @Test
    void getById() {
        // Act
        Optional<PostResponse> postResponse = postGateway.getById(1);

        // Assert
        assertEquals(1, postResponse.get().getUserId());
        assertEquals(1, postResponse.get().getId());

    }
}