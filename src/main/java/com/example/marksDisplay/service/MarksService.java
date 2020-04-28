package com.example.marksDisplay.service;

import com.example.marksDisplay.service.thread.MailThread;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MarksService {

    public String sendOTP(String object){
        String email=new JSONObject(object).getString("email");
        String content="<h1>OTP for viewing marks : {}</h1>";
        String otp=generateOTP();

        content=content.replace("{}",otp);

        MailThread mailThread=new MailThread();
        mailThread.setData(email,content);
        Thread thread=new Thread(mailThread);
        thread.start();

        return otp;
    }

    private String generateOTP(){
        Random random=new Random();
        StringBuilder stringBuilder=new StringBuilder();

        for(int i=0;i<4;i++){
            int temp=random.nextInt(10);
            stringBuilder.append(temp);
        }

        return stringBuilder.toString();
    }
}
