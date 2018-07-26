package com.spring;

import com.spring.dao.SingerDao;
import com.spring.dao.SingerDaoImpl;
import com.spring.entidad.Singer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SingerServiceApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context= SpringApplication.run(SingerServiceApplication.class, args);

        SingerDao singerDao=context.getBean(SingerDaoImpl.class);
        /*
        Singer singer = new Singer();
        singer.setFirstName("john");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
                new GregorianCalendar(1977,9,16).getTime().getTime()
        ));
        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("Eric");
        singer.setLastName("Clapton");
        singer.setBirthDate(new Date(
                new GregorianCalendar(1945,2,3).getTime().getTime()
        ));
        singerDao.save(singer);

        singer = new Singer();
        singer.setFirstName("john");
        singer.setLastName("Butler");
        singer.setBirthDate(new Date(
                new GregorianCalendar(1975,3,1).getTime().getTime()
        ));
        singerDao.save(singer);

        */
        List<Singer> singers=singerDao.findAll();
        System.out.println(singers);

    }

}
