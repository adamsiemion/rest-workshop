package com.workshop.rest;

import java.util.List;

public interface UserService {
    List<String> list();

    void create(String user);
}
