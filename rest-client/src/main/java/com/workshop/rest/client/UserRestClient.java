package com.workshop.rest.client;

import com.workshop.rest.server.User;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class UserRestClient {
    public static void main(String[] args) {
        final RestTemplate restTemplate = new RestTemplate();

        final User newUser = new User("John Snow");
        final String id = restTemplate.postForObject("http://localhost:8021/users", newUser, String.class);

        final User createdUser = restTemplate.getForObject("http://localhost:8021/users/{id}", User.class, id);
        System.out.println(createdUser.getName());
    }
}
