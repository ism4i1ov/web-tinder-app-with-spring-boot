package org.tinder.tinder.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDateTime;

@Data
@Builder
public class User {
    @NonNull
    Long id;
    String name;
    String surname;
    String username;
    String password;
    String avatarLink;
    LocalDateTime lastLogin;
    String profession;
}
