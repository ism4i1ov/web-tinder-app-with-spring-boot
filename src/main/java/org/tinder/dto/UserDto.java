package org.tinder.dto;

import org.tinder.entity.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;

public class UserDto {

    private Long id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String avatarLink;
    private LocalDateTime localDateTime;
    private String profession;


    public static UserDto toDto(User user) {
        return new UserDto()
                .setId(user.getId())
                .setName(user.getName())
                .setSurname(user.getSurname())
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setAvatarLink(user.getAvatarLink())
                .setLocalDateTime(user.getLastLogin())
                .setProfession(user.getProfession());
    }

    public String getFullName() {
        return name + " " + surname;
    }

    public Long getId() {
        return id;
    }

    public UserDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserDto setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDto setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDto setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public UserDto setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
        return this;
    }

    public String getLastLogin() {
        return "Last login " + localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }


    public UserDto setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
        return this;
    }

    public String getProfession() {
        return profession;
    }

    public UserDto setProfession(String profession) {
        this.profession = profession;
        return this;
    }
}
