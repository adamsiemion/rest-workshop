package com.workshop.rest;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookService {
    private Map<Integer, Book> store = new HashMap<>();

    public BookService() {
        store.put(1, new Book(1, "REST"));
        store.put(2, new Book(2, "Java 8", false));
    }

    public List<Book> list() {
        return new ArrayList<>(store.values());
    }

    public Book get(int id) throws UserIsInactiveException {
        Book book = store.get(id);
        if(book == null) {
            throw new BookNotFoundException(id);
        }
        if(!book.isActive()) {
            throw new UserIsInactiveException(id);
        }
        return book;
    }

}
