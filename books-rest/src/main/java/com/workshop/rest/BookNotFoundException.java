package com.workshop.rest;

public class BookNotFoundException extends RuntimeException {
    private final int id;

    public BookNotFoundException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
