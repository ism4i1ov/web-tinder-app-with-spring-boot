package org.tinder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/not-found")
public class NotFoundController {

    @GetMapping
    public String getTemplate() {
        return "not-found";
    }
}
