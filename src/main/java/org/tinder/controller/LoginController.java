package org.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tinder.entity.User;
import org.tinder.service.LoginService;

import java.util.Optional;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping
    public String getTemplate() {
        return "login";
    }

    @PostMapping
    public String findByUsernameAndPassword(String username, String password, Model model) {
        Optional<User> optionalUser = loginService.findByUsername(username);
        return optionalUser.map(user -> {
            if(!user.getPassword().equals(password)){
                return "not-found";
            }
            model.addAttribute("user", user);
            return "users";
        }).orElse("not-found");
    }
}
