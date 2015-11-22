package com.workshop.level1;

import java.util.List;

public interface UserService {
    List<String> list();

    void create(String user);
}
