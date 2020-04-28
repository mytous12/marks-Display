package com.example.marksDisplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MarksController {
    @GetMapping("/index")
    public String demo() {
        return "I'm running";
    }
}
