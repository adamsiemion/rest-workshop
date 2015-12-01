package com.workshop.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BooksRestApplication.class)
@WebIntegrationTest
public class BooksRestTest {

    @Test
    public void shouldReturnBookInJson() throws URISyntaxException {
        // given
        RestTemplate restTemplate = new TestRestTemplate();
        // when
        String book = restTemplate.getForObject("http://localhost:8101/books/1", String.class);
        // then
        assertEquals("{\"id\":3,\"name\":\"REST\"}", book);
    }

    @Test
    public void shouldReturnBooks() {
        // given
        RestTemplate restTemplate = new TestRestTemplate();
        // when
        List<Book> books = Arrays.asList(restTemplate.getForObject("http://localhost:8101/books", Book[].class));
        // then
        assertEquals(Arrays.asList(new Book(1, "REST")), books);
    }
}