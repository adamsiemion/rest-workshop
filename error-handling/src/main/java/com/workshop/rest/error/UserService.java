package com.workshop.rest.error;

import java.util.List;

public interface UserService {
    List<User> list();

    long create(User user);

    User get(long id) throws UserIsInactiveException;

    void delete(long id);
}
