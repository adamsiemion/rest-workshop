package com.workshop.rest.level0;

import java.util.List;

public interface UserService {
    List<String> list();

    void create(String user);
}
