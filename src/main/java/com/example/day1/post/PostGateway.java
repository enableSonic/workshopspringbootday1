package com.example.day1.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class PostGateway {

    @Autowired
    private RestTemplate restTemplate;

    public Optional<PostResponse> getById(int postId){
        String url = "https://jsonplaceholder.typicode.com/posts/" +postId;
        try {
            PostResponse postResponse =  restTemplate.getForObject(url,PostResponse.class);
            return Optional.ofNullable(postResponse);
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

}
