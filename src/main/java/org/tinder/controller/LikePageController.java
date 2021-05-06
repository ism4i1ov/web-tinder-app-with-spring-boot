package org.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinder.entity.User;
import org.tinder.service.impl.UsersLike;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/like-page")
@AllArgsConstructor
public class LikePageController {

    private final UsersLike usersLike;

    @GetMapping
    public String getTemplate(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:not-found";
        }
        Long id = user.getId();
        User enemy = usersLike.getUsersForLike(id);
        if (enemy == null) {
            return "redirect:people-list";
        }
        model.addAttribute("enemy", enemy);
        session.setAttribute("enemy", enemy);
        return "like-page";
    }

    @PostMapping
    public String getNextUser(HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            return "redirect:not-found";
        }
        User enemy = (User) httpSession.getAttribute("enemy");
        usersLike.likeOrDislikeUser(user.getId(), enemy.getId(), 1L);
        return "redirect:like-page";
    }
}
