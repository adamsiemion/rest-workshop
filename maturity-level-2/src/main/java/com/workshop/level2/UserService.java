package com.workshop.level2;

import java.util.List;

public interface UserService {
    List<User> list();

    void create(User user);
}
