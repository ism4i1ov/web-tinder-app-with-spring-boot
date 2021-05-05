package org.tinder.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tinder.repository.UserRepository;
import org.tinder.entity.User;
import org.tinder.service.inter.SignUpInter;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpInter {

    private final UserRepository userRepository;

    @Override
    public Optional<User> createUser(User user) {
        return userRepository.create(user);
    }
}
