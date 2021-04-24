package org.tinder.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.tinder.dao.UserDao;
import org.tinder.entity.User;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService {
    private final UserDao userDao;

    public Optional<User> findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
