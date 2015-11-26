package com.workshop.rest.level3;

import java.util.List;

public interface UserService {
    List<User> list();

    long create(User user);

    User get(long id);

    void delete(long id);
}
