package com.example.marksDisplay.service.thread;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Date;
import java.util.Properties;

public class MailThread implements Runnable {

    private String email;
    private final String subject = "Marks of NALR";
    private String content;

    @Override
    public void run() {
        try{
            sendMail();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setData(String email, String content){
        this.email=email;
        this.content=content;
    }

    private void sendMail() throws MessagingException {
        Properties properties=new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        Session session=Session.getInstance(properties,new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                //get company email and password
                return new PasswordAuthentication("rishabhmalhotra9211@gmail.com","SyncMasterB1930");
            }
        });

        Message message=new MimeMessage(session);
        message.setFrom(new InternetAddress("rishabhmalhotra9211@gmail.com",false));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.email));
        message.setSubject(subject);
        message.setSentDate(new Date());

        MimeBodyPart mimeBodyPart=new MimeBodyPart();
        mimeBodyPart.setContent(content,"text/html");

        Multipart multipart=new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }
}
