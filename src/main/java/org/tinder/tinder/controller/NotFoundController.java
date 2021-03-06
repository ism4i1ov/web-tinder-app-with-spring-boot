package org.tinder.tinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notfound")
public class NotFoundController {

    @GetMapping
    public String getTemplate() {
        return "notfound";
    }
}
