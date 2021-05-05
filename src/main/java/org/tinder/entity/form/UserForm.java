package org.tinder.entity.form;

import lombok.Data;

@Data
public class UserForm {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String avatar_link;
    private String profession;
    private String confirm_password;
}
