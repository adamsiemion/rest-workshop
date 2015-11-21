package com.workshop.rest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserService {
    private List<String> userList = new ArrayList<>();

    public List<String> list() {
        return Collections.unmodifiableList(userList);
    }

    public void create(final String user) {
        userList.add(user);
    }
}
