package com.workshop.rest.error;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class UserServiceImpl implements UserService {
    private Map<Long, User> userMap = new HashMap<>();
    private static long userId;

    @Override
    public List<User> list() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public long create(final User user) {
        long id = userId++;
        user.setActive(randomBoolean());
        user.setDeleted(randomBoolean());
        user.setArchived(randomBoolean());
        user.setId(id);
        userMap.put(id, user);
        return id;
    }

    private boolean randomBoolean() {
        return Math.random() > 0.5;
    }

    @Override
    public User get(long id) throws UserIsInactiveException {
        User user = userMap.get(id);
        if(!user.isActive()) throw new UserIsInactiveException(id);
        if(user.isDeleted()) throw new UserIsDeletedException(id);
        if(user.isArchived()) throw new UserIsArchivedException(id);
        return user;
    }

    @Override
    public void delete(long id) {
        userMap.remove(id);
    }
}
