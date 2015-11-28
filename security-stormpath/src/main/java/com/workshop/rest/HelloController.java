package com.workshop.rest;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @since 1.0.RC4.4
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping("/")
    String home(HttpServletRequest request) {

        String name = "World";

        Account account = AccountResolver.INSTANCE.getAccount(request);
        if (account != null) {
            name = account.getGivenName();
        }

        return "Hello " + name + "!";
    }

    @RequestMapping("/restricted")
    String restricted(HttpServletRequest request) {
        return helloService.sayHello(AccountResolver.INSTANCE.getAccount(request));
    }

}