package org.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tinder.entity.User;
import org.tinder.service.impl.LoginServiceImpl;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class LoginController {

    private final LoginServiceImpl loginServiceImpl;

    @GetMapping
    public String getTemplate() {
        return "login";
    }

    @PostMapping
    public String findByUsernameAndPassword(String username, String password, HttpSession session) {
        Optional<User> optionalUser = loginServiceImpl.findByUsername(username);
        return optionalUser.map(user -> {
            if (!user.getPassword().equals(password)) {
                return "redirect:not-found";
            }
            session.setAttribute("user", user);
            return "redirect:like-page";
        }).orElse("redirect:not-found");
    }
}
