package com.workshop.rest;

public class UserIsInactiveException extends Throwable {
    private final int id;

    public UserIsInactiveException(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
