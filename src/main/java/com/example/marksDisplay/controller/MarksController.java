package com.example.marksDisplay.controller;

import com.example.marksDisplay.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class MarksController {


    @Autowired
    private MarksService marksService;

    @GetMapping("/demo")
    @GetMapping("/")
    public String demo() {
        return "I'm running";
    }

    @PostMapping("/getOTP")
    public String getOTP(@RequestBody String emailJSON){
        try{
            return marksService.sendOTP(emailJSON);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
