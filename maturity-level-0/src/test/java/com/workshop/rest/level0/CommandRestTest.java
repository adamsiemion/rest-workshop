package com.workshop.rest.level0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MaturityLevel0Application.class)
@WebIntegrationTest
public class CommandRestTest {

    private RestTemplate restTemplate = new TestRestTemplate();

    @Component
    @Primary
    static class UserServiceMock implements UserService {
        @Override
        public List<String> list() {
            return Arrays.asList("John Snow");
        }

        @Override
        public void create(String user) {  }
    }

    @Test
    public void shouldReturnJohnSnowInListOfUsers() {
        // given
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity entity = new HttpEntity<>("{\"method\":\"listUsers\"}", headers);
        // when
        final String result = restTemplate.postForObject("http://localhost:7001/rest", entity, String.class);
        // then
        assertEquals("{\"result\":\"John Snow\"}", result);
    }

}


