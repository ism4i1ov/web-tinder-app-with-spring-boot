package org.tinder.service.inter;

import org.tinder.entity.User;

import java.util.Optional;

public interface LoginServiceInter {

    Optional<User> findByUsername(String username);
}
