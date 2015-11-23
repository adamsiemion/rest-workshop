package com.workshop.rest.cors.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class CorsBackendApplication {

    @RequestMapping("/simple-no-cors-headers-in-response")
    String simpleNoCorsHeadersInResponse() {
        return "Hello!";
    }

    @RequestMapping("/simple-cors-headers-in-response")
    String simpleCorsHeadersInResponse(final HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8083");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        return "Hello!";
    }

    @CrossOrigin(origins = "http://localhost:8083")
    @RequestMapping("/simple-cors-cross-origin-annotation")
    String simpleCorsCrossOriginAnnotation() {
        return "Hello!";
    }

    public static void main(String[] args) {
        SpringApplication.run(CorsBackendApplication.class, args);
    }
}
