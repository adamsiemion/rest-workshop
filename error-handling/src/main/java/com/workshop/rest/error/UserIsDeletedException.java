package com.workshop.rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "User is deleted")
public class UserIsDeletedException extends RuntimeException {
    private final long userid;

    public UserIsDeletedException(long userid) {
        this.userid = userid;
    }

    public long getUserid() {
        return userid;
    }
}
