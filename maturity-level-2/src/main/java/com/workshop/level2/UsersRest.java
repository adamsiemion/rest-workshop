package com.workshop.level2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersRest {

    @Autowired private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list() {
        return userService.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void create(User newUser) {
        userService.create(newUser);
    }

}
