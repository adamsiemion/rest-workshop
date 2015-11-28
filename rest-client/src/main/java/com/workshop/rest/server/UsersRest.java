package com.workshop.rest.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersRest {

    @Autowired private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User list(@PathVariable("id") final int id) {
        return userService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody final User newUser) {
        return String.valueOf(userService.create(newUser));
    }

}
