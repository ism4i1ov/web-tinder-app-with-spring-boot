package org.tinder.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.tinder.dto.UserDto;
import org.tinder.entity.User;
import org.tinder.service.impl.UsersLike;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("people-list")
@AllArgsConstructor
public class PeopleListController {

    private final UsersLike usersLike;

    @GetMapping
    public String getTemplate(HttpSession session, Model model) {
        UserDto user = (UserDto) session.getAttribute("user");
        if (user == null) {
            return "redirect:not-found";
        }
        List<UserDto> collect = usersLike.getLikedUsers(user.getId())
                .stream()
                .map(UserDto::toDto)
                .collect(Collectors.toList());
        model.addAttribute("likedUsers", collect);
        return "liked-peoples";
    }
}
