package com.spring.rabbit;

import com.spring.Application;
import com.spring.entidad.Instrument;
import com.spring.mail.EmailServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component("messageListener")
public class InstrumentMessageListener {
    @Autowired
    EmailServiceImpl emailService;

    @RabbitListener(queues = Application.QUEUE_SPECIFIC_NAME)
    public void receiveMessagex(Instrument instrument) throws MessagingException {
        System.out.println(">>>Mensaje recibido:" +instrument.toString());
        emailService.sendEmail(instrument.getInstrumentId());
        System.out.println(">>> Enviando instrumento nuevo: " + instrument.getInstrumentId());
    }
}

