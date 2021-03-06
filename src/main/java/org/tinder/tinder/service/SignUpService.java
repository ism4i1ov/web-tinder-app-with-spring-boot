package org.tinder.tinder.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.tinder.tinder.dao.UserDao;
import org.tinder.tinder.entity.User;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SignUpService {
    private final UserDao userDao;

    public Optional<User> createUser(User user) {
        return userDao.create(user);
    }
}
