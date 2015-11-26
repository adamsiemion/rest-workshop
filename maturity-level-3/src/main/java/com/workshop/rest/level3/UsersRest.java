package com.workshop.rest.level3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * url: http://localhost:8093/users
 */
@RestController
@RequestMapping("/users")
public class UsersRest {

    @Autowired private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> list() {
        List<User> users = userService.list();
        for(User user : users) {
            addHateosLinks(user);
        }
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable Long id) {
        return addHateosLinks(userService.get(id));
    }

    private User addHateosLinks(User user) {
        user.add(linkTo(methodOn(UsersRest.class).get(user.getUserid())).withSelfRel());
        user.add(linkTo(methodOn(UsersRest.class).delete(user.getUserid())).withRel("delete"));
        user.add(linkTo(methodOn(UsersRest.class).email(user.getUserid())).withRel("email"));
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }

    /**
     * body: {"name":"John Snow"}
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody User newUser) {
        long id = userService.create(newUser);

        URI uri = linkTo(methodOn(UsersRest.class).get(id)).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}/email", method = RequestMethod.PUT)
    public ResponseEntity<Void> email(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

}
