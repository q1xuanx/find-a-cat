package com.game.find_a_cat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cat")
public class CatHidingController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Mr Meow Is Very Good at: " + System.currentTimeMillis();
    }


}
