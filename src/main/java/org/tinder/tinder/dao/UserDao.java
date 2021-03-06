package org.tinder.tinder.dao;

import org.springframework.stereotype.Repository;
import org.tinder.tinder.entity.User;

import java.util.Optional;

@Repository
public class UserDao {
    public Optional<User> findByUsernameAndPassword(String username, String password) {
        return Optional.empty();
    }

    public Optional<User> create(User user) {
        return Optional.of(user);
    }


}
