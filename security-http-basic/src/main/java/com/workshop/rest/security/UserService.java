package com.workshop.rest.security;

import java.util.List;

public interface UserService {
    List<User> list();

    void create(User user);
}
