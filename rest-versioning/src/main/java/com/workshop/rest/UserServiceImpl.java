package com.workshop.rest;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private List<User> userList = new ArrayList<>();

    @Override
    public List<User> list() {
        return Collections.unmodifiableList(userList);
    }

    @Override
    public void create(final User user) {
        userList.add(user);
    }
}
