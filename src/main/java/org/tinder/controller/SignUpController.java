package org.tinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tinder.entity.User;
import org.tinder.entity.UserInfo;
import org.tinder.service.SignUpService;

import java.time.LocalDateTime;

@Controller
@RequestMapping("sign_up")
public class SignUpController {

    private final SignUpService signUpService;

    @Autowired
    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public String getTemplate() {
        return "sign_up";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserInfo user, Model map) {
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setAvatarLink(user.getAvatar_link());
        newUser.setProfession(user.getProfession());
        newUser.setLastLogin(LocalDateTime.now());

        if (!user.getPassword().equals(user.getConfirm_password())) return "redirect:not-found";
        return signUpService.createUser(newUser).map(opUser -> {
            map.addAttribute("user", opUser);
            return "redirect:like-page";
        }).orElse("redirect:not_found");
        // aida457qahan
    }
}
