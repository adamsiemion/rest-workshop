package com.workshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * url: http://localhost:8061/users
 */
@RestController
@RequestMapping("/users")
public class UsersRest {

    @Autowired private UserService userService;

    /**
     * header:
     * Accept:application/vnd.users-1+json
     */
    @RequestMapping(method = RequestMethod.GET, headers = {
        "Accept=application/vnd.users-1+json"
    })
    public List<UserDtoV1> listV1() {
        return userService.list().stream().map(u -> new UserDtoV1(u)).collect(Collectors.toList());
    }

    /**
     * header:
     * Accept:application/vnd.users-2+json
     */
    @RequestMapping(method = RequestMethod.GET, headers = {
        "Accept=application/vnd.users-2+json"
    })
    public List<UserDtoV2> listV2() {
        return userService.list().stream().map(u -> new UserDtoV2(u)).collect(Collectors.toList());
    }

    /**
     * {"firstName":"John", "lastName":"Snow3"}
     */
    @RequestMapping(method = RequestMethod.POST, headers = {
            "Accept=application/vnd.users-1+json"
    })
    public void createV1(@RequestBody UserDtoV1 newUser) {
        userService.create(newUser.convert());
    }

    /**
     * {"name":"John Snow2"}
     */
    @RequestMapping(method = RequestMethod.POST, headers = {
            "Accept=application/vnd.users-2+json"
    })
    public void createV2(@RequestBody UserDtoV2 newUser) {
        userService.create(newUser.convert());
    }

}
