package org.tinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/like-page")
public class LikePageController {

    @GetMapping
    public String getTemplate() {
        return "like-page";
    }
}
