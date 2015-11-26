package com.workshop.rest;

import com.workshop.level2.User;
import com.workshop.level2.UserService;
import com.workshop.level2.UserServiceImpl;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void shouldIncludeTheNewlyAddedUserInTheList() {
        // given
        final UserService service = new UserServiceImpl();
        service.create(new User("John Snow"));
        // when
        List<User> users = service.list();
        // then
        assertEquals(1, users.size());
        assertEquals("John Snow", users.get(0).getName());
    }

}