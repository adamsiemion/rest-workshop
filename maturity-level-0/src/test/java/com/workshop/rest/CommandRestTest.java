package com.workshop.rest;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MaturityLevel0Application.class)
@WebIntegrationTest
public class CommandRestTest {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Autowired UserService userService;

    @Before
    public void addOneUser() {
        userService.create("John Snow");
    }

    @Test
    public void f() throws URISyntaxException {
        // given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>("{\"method\":\"listUsers\"}", headers);
        // when
        final String result = restTemplate.postForObject("http://localhost:8888/rest", entity, String.class);
        // then
        assertEquals("{\"result\":\"John Snow\"}", result);
    }

}
