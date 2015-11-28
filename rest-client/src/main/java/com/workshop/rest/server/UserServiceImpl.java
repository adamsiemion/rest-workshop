package com.workshop.rest.server;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {
    private Map<Long, User> userMap = new HashMap<>();
    private static long userId;

    @Override
    public List<User> list() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public long create(final User user) {
        long id = userId++;
        user.setId(id);
        userMap.put(id, user);
        return id;
    }

    @Override
    public User get(long id) {
        return userMap.get(id);
    }
}
