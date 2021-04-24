package org.tinder.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tinder.entity.User;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    default Optional<User> create(User user) {
        return Optional.of(save(user));
    }
}
