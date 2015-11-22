package com.workshop.level1;

import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesRest {

    @RequestMapping(method = RequestMethod.GET)
    public Response execute(@RequestParam("command") final String command,
        @RequestParam(value = "argument", required = false) final String argument) {
        if("list".equals(command)) {
            return new Response("list" /* userService.list().stream().collect(Collectors.joining(",") */);
        } else if ("add".equals(command)) {
            return new Response("add " + argument);
        }
        throw new RuntimeException("Unknown method " + command);
    }

}
