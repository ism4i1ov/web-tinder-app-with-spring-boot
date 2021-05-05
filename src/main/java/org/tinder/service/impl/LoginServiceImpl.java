package org.tinder.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.tinder.repository.UserRepository;
import org.tinder.entity.User;
import org.tinder.service.inter.LoginServiceInter;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginServiceInter {
    private final UserRepository userRepository;

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
