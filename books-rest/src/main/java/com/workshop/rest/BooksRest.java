package com.workshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
            return ResponseEntity.ok(addHateoasLinks(bookService.get(id)));
        } catch (UserIsInactiveException e) {
            return new ResponseEntity<Book>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<Void> score(@PathVariable("id") final int id) {
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    private Book addHateoasLinks(Book book) throws UserIsInactiveException {
        book.add(linkTo(methodOn(BooksRest.class).get(book.getBookid())).withSelfRel());
        book.add(linkTo(methodOn(BooksRest.class).score(book.getBookid())).withRel("score"));
        return book;
    }
}
