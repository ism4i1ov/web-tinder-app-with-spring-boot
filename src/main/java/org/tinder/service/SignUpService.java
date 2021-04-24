package org.tinder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinder.dao.UserDao;
import org.tinder.entity.User;

import java.util.Optional;

@Service
public class SignUpService {
    private final UserDao userDao;

    @Autowired
    public SignUpService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Optional<User> createUser(User user) {
        return userDao.create(user);
    }
}
