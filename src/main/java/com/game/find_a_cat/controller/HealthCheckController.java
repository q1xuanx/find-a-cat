package com.game.find_a_cat.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "Mr Meow Is Very Good at: " + System.currentTimeMillis();
    }
}
