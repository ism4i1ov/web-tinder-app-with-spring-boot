package org.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tinder.entity.User;
import org.tinder.entity.UsersLikes;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserLikesRepository extends JpaRepository<UsersLikes, Long> {

    boolean existsByLikerUserIdAndLikedUserIdAndLikeId(Long likerUserId, Long likedUserId, Long likeId);

    @Modifying
    @Query(nativeQuery = true,
            value = "insert into users_likes (id, liker_user_id, liked_user_id, like_id) " +
                    "values (default, ?1, ?2, ?3)")
    void likeOrDislikeUser(Long likerUserId, Long likedUserId, Long likeId);

    @Modifying
    @Query(nativeQuery = true,
            value = "update users_likes set like_id = ?1 where liked_user_id = ?2 and liker_user_id = ?3")
    void updateUserLike(Long likeId, Long likedUserId, Long likerUserId);
}
