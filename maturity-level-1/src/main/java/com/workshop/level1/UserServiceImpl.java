package com.workshop.level1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private List<String> userList = new ArrayList<>();

    @Override
    public List<String> list() {
        return Collections.unmodifiableList(userList);
    }

    @Override
    public void create(final String user) {
        userList.add(user);
    }
}
