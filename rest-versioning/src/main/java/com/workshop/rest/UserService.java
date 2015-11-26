package com.workshop.rest;

import java.util.List;

public interface UserService {
    List<User> list();

    void create(User user);
}
