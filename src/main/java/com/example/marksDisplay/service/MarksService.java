package com.example.marksDisplay.service;

import com.example.marksDisplay.service.thread.MailThread;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Random;

@Service
public class MarksService {

    private static JSONArray jsonArray;

    public MarksService(){
        jsonArray=new JSONArray();
    }

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

    public boolean addData(String data) throws IOException {
//        InputStream inputStream= MarksService.class.getResourceAsStream("/data.json");
//        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
//        StringBuilder stringBuilder=new StringBuilder();
//        String line;
//
//        while ((line=bufferedReader.readLine()) != null){
//            stringBuilder.append(line);
//        }
//
//        JSONArray jsonArray=new JSONArray(stringBuilder.toString());
//        jsonArray.put(jsonArray.length()-1,data);
//
//
//        FileWriter fileWriter=new FileWriter();
//        BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
//        bufferedWriter.write(jsonArray.toString());
//        bufferedWriter.close();

        jsonArray.put(data);

        return true;
    }

    public String getData(String emailJSON){
        String email=new JSONObject(emailJSON).getString("email");
        for(int i=0;i<jsonArray.length();i++) {
            JSONObject jsonObject= new JSONObject(jsonArray.get(i).toString());

            if(jsonObject.getString("email").toLowerCase().equals(email.toLowerCase())){
                return jsonObject.toString();
            }
        }

        return null;
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
