package com.workshop.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(UserService.class)
public class UserServiceTest {

    @Autowired UserService service;

    @Test
    public void shouldIncludeTheNewlyAddedUserInTheList() {
        // given
        service.create("John Snow");
        // when
        List<String> users = service.list();
        // then
        assertEquals(1, users.size());
        assertEquals("John Snow", users.get(0));
    }

}