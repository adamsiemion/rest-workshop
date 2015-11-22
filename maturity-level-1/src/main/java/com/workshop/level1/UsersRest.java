package com.workshop.level1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UsersRest {

    @Autowired private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Response execute(@RequestBody Command command) {
        if("list".equals(command.getMethod())) {
            return new Response(userService.list().stream().collect(Collectors.joining(",")));
        } else if ("add".equals(command.getMethod()) && command.getArguments().size() == 1) {
            userService.create(command.getArguments().get(0));
            return new Response("ok");
        }
        throw new RuntimeException("Unknown method " + command.getMethod());
    }

}
