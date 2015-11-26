package com.workshop.rest.error;

public class UserIsArchivedException extends RuntimeException {
    private long userid;

    public UserIsArchivedException(long id) {
        this.userid = id;
    }

    public long getUserid() {
        return userid;
    }
}
