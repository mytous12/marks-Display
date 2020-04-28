package com.example.marksDisplay.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/marks")
public class MarksController {
    @GetMapping("/demo")
    public String demo() {
        return "I'm running";
    }
}
