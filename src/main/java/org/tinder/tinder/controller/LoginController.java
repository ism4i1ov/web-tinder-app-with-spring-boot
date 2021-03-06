package org.tinder.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.tinder.tinder.entity.User;
import org.tinder.tinder.service.LoginService;

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
    public String findByUsernameAndPassword(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        Optional<User> optionalUser = loginService.findByUsernameAndPassword(username, password);
        return optionalUser.map(user -> {
            model.addAttribute("user", user);
            return "users";
        }).orElse("notfound");
    }
}
