package com.spring.mail;

import com.spring.entidad.Singer;
import javax.mail.MessagingException;
import java.util.List;

public interface EmailService {

    void sendEmail(String to, String subject, List<Singer> singers) throws MessagingException;
    void sendEmail(String mensaje)throws MessagingException;
}
