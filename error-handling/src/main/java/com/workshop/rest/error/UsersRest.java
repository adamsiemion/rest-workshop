package com.workshop.rest.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) throws UserIsInactiveException {
        return userService.get(id);
    }

    @ExceptionHandler(UserIsInactiveException.class)
    void handleUserIsInactiveException(final UserIsInactiveException exception,
            final HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value(), String.format("User %d is inactive", exception.getUserid()));
    }
}
