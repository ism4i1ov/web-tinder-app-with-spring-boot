package org.tinder.entity;

import lombok.Data;

@Data
public class UserInfo {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String avatar_link;
    private String profession;
    private String confirm_password;
}
