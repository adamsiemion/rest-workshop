package com.workshop.rest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersRest {

    @Autowired private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody final User newUser) {
        userService.create(newUser);
    }

}
