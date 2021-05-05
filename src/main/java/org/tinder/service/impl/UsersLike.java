package org.tinder.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.tinder.entity.User;
import org.tinder.entity.UsersLikes;
import org.tinder.repository.UserLikesRepository;
import org.tinder.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersLike {

    private final UserLikesRepository userLikesRepository;
    private final UserRepository userRepository;

    public User getUsersForLike(Long id) {
        return userRepository.findUsersToLike(id);
    }

    public void likeOrDislikeUser(Long likerUserId, Long likedUserId, Long likeId) {
        if (userLikesRepository.existsByLikerUserIdAndLikedUserIdAndLikeId(likerUserId, likedUserId, 2L)) {
            userLikesRepository.updateUserLike(likeId, likedUserId, likerUserId);
        } else {
            userLikesRepository.likeOrDislikeUser(likerUserId, likedUserId, likeId);
        }
    }
}
