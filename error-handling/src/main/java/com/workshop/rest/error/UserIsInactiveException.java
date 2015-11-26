package com.workshop.rest.error;

public class UserIsInactiveException extends Exception {
    private final long userid;

    public UserIsInactiveException(final long id) {
        this.userid = id;
    }

    public long getUserid() {
        return userid;
    }
}
