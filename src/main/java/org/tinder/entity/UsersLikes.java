package org.tinder.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users_likes")
public class UsersLikes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "liker_user_id")
    private Long likerUserId;
    @Column(name = "liked_user_id")
    private Long likedUserId;
    @Column(name = "like_id")
    private Long likeId;


}
