package com.workshop.rest.server;

import java.util.List;

public interface UserService {
    List<User> list();

    long create(User user);

    User get(long id);
}
