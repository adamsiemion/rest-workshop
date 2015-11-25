package com.workshop.rest.cors.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/not-simple-no-options-defined", method = RequestMethod.PUT)
    String notSimpleNoOptionsDefined() {
        return "{\"msg\":\"hello\"}";
    }

    @RequestMapping(value = "/not-simple-options-defined", method = RequestMethod.PUT)
    String notSimpleOptionsDefined(final HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8083");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        return "{\"msg\":\"hello\"}";
    }

    @RequestMapping(value = "/not-simple-options-defined", method = RequestMethod.OPTIONS)
    void notSimpleOptionsDefinedOptions(final HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:8083");
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Allow-Methods", "PUT");
    }

    @CrossOrigin(origins = "http://localhost:8083")
    @RequestMapping(value = "/not-simple-cors-cross-origin-annotation", method = RequestMethod.PUT)
    String notSimpleCorsCrossOriginAnnotation() {
        return "{\"msg\":\"hello\"}";
    }


    public static void main(String[] args) {
        SpringApplication.run(CorsBackendApplication.class, args);
    }
}
