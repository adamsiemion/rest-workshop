package com.workshop.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksRest {
    @RequestMapping(method = RequestMethod.GET)
    public List<Book> list() {
        return Arrays.asList(new Book(1, "REST"));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book get(@PathVariable("id") final int id) {
        return new Book(id, "REST");
    }
}
