package com.FlightAPI.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailUtil {


    @Autowired
    private JavaMailSender javaMailSender;


//    public void sendEmail(String to, String subject, String messege) {
//
//        SimpleMailMessage m=new SimpleMailMessage();
//        m.setTo(to);
//        m.setSubject(subject);
//        m.setText(messege);
//
//        javaMailSender.send(m);
//    }

    public void sendItinerary(String toAddress, String filePath) {
        System.out.println(filePath);

        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(toAddress);
            messageHelper.setSubject("Itinerary Of Flight");
            messageHelper.setText("Please find the attached");
            messageHelper.addAttachment("Itinerary", new File(filePath) );
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
