package org.tinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tinder.dto.UserDto;
import org.tinder.entity.User;
import org.tinder.entity.form.UserForm;
import org.tinder.service.impl.SignUpServiceImpl;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

@Controller
@RequestMapping("sign_up")
public class SignUpController {

    private final SignUpServiceImpl signUpServiceImpl;

    @Autowired
    public SignUpController(SignUpServiceImpl signUpServiceImpl) {
        this.signUpServiceImpl = signUpServiceImpl;
    }

    @GetMapping
    public String getTemplate(HttpSession session) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user != null) {
            return "redirect:like-page";
        }
        return "sign_up";
    }

    @PostMapping
    public String createUser(@ModelAttribute UserForm user, Model map) {

        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setAvatarLink(user.getAvatar_link());
        newUser.setProfession(user.getProfession());
        newUser.setLastLogin(LocalDateTime.now());

        if (!user.getPassword().equals(user.getConfirm_password())) return "redirect:not-found";
        return signUpServiceImpl.createUser(newUser).map(opUser -> {
            map.addAttribute("user", opUser);
            return "redirect:like-page";
        }).orElse("redirect:not-found");
        // aida457qahan
    }
}
