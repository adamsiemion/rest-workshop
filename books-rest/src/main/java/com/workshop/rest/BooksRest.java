package com.workshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BooksRest {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> list() {
        return bookService.list();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Book> get(@PathVariable("id") final int id) throws UserIsInactiveException {
        try {
            return ResponseEntity.ok(bookService.get(id));
        } catch (UserIsInactiveException e) {
            return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
        }
    }

}
