package org.tinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {
    @PostMapping
    public String logout(HttpSession session) {
        session.setAttribute("user", null);
        return "redirect:/";
    }
}
