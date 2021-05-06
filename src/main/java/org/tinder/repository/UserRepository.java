package org.tinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tinder.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true,
            value = "select u.*\n" +
                    "from users u\n" +
                    "where (select count(*)\n" +
                    "       from users_likes\n" +
                    "       where (like_id = 1 or like_id is null)\n" +
                    "         and liker_user_id = ?1\n" +
                    "         and liked_user_id = u.id) = 0\n" +
                    "  and u.id != ?1 order by  rand() limit 1")
    User findUsersToLike(Long userId);

    Optional<User> findByUsername(String username);

    @Query(nativeQuery = true,
    value = "select u.* " +
            "from users_likes ul " +
            "         left join users u on u.id = ul.liked_user_id " +
            "where  ul.liker_user_id = ?1")
    List<User> getLikedUsers(Long id);

    default Optional<User> create(User user) {
        return Optional.of(save(user));
    }
}
