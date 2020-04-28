package com.example.marksDisplay.controller;

import com.example.marksDisplay.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping(path = "/addData")
    public boolean addData(@RequestBody String data){
        try{
            return marksService.addData(data);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @PostMapping(path = "/getData")
    public String getData(@RequestBody String email){
        return marksService.getData(email);
    }

    @GetMapping("/demo")
    public String demo() {
        return "I'm running";
    }

    @PostMapping(path = "/getOTP")
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
