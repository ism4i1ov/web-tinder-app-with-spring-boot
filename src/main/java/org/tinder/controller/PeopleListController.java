package org.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinder.entity.User;
import org.tinder.service.impl.UsersLike;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("people-list")
@AllArgsConstructor
public class PeopleListController {

    private final UsersLike usersLike;

    @GetMapping
    public String getTemplate(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:not-found";
        }
        List<User> likedUsers = usersLike.getLikedUsers(user.getId());
        model.addAttribute("likedUsers", likedUsers);
        return "liked-peoples";
    }
}
