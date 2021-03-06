package org.tinder.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tinder.tinder.entity.User;
import org.tinder.tinder.service.SignUpService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("sign_up")
@AllArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @GetMapping
    public String getTemplate() {
        return "sign_up";
    }

    @PostMapping
    public String createUser(@RequestParam("name") String name, @RequestParam("surname") String surname,
                             @RequestParam("username") String username, @RequestParam("password") String password,
                             @RequestParam("confirm_password") String confirmPassword, @RequestParam("avatar_link") String avatarLink,
                             @RequestParam("profession") String profession, Model map) {

        User newUser = User.builder()
                .name(name)
                .surname(surname)
                .username(username)
                .password(password)
                .lastLogin(LocalDateTime.now())
                .profession(profession)
                .avatarLink(avatarLink)
                .build();

        return signUpService.createUser(newUser).map(user -> {
            map.addAttribute("user", user);
            return "users";
        }).orElse("notfound");
    }
}
