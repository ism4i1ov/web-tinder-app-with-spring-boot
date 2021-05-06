package org.tinder.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    Long id;
    @Column(name = "name")
    @Basic(optional = false)
    String name;
    @Column(name = "surname")
    @Basic(optional = false)
    String surname;
    @Column(name = "username")
    @Basic(optional = false)
    String username;
    @Column(name = "password")
    @Basic(optional = false)
    String password;
    @Column(name = "avatar_link")
    @Basic(optional = false)
    String avatarLink;
    @Column(name = "last_login")
    @Basic(optional = false)
    LocalDateTime lastLogin;
    @Column(name = "profession")
    String profession;

}
