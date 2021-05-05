package org.tinder.service.inter;

import org.tinder.entity.User;

import java.util.Optional;

public interface SignUpInter {

    Optional<User> createUser(User user);
}
