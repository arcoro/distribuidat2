package com.spring.mail;

import com.spring.dao.SingerDaoImpl;
import com.spring.entidad.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Autowired
    public SingerDaoImpl singerDao;

    @Override
    public void sendEmail(String mensaje) throws MessagingException {

        MimeMessage mimeMessage = emailSender.createMimeMessage();
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage, false, "utf-8");

        mimeMessage.setContent(buildHtmlMessage(mensaje), "text/html");
        message.setSubject("Notificacion nuevo ingreso");
        /*message.setTo("alex_negro1991@hotmail.com");
        emailSender.send(mimeMessage);*/
        List<Singer> singers=singerDao.findAll();
        String [] emails=new String[singers.size()];
        for(int i =0; i<singers.size();i++){
            emails[i]=singers.get(i).getEmail();
        }
        message.setTo(emails);
        emailSender.send(mimeMessage);

    }

    private String buildHtmlMessage(String mensaje) {
        String message = "<h2>Sea ingresado un nuevo instrumento: </h2>"+"<h3> "+mensaje+" </h3>";
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return message;
    }


    @Override
    public void sendEmail(String to, String subject, List<Singer> singers) throws MessagingException {

    }
}
