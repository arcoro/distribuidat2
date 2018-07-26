package com.spring.servicios;

import com.spring.dao.SingerDaoImpl;
import com.spring.entidad.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

import java.util.List;

@RestController
@RequestMapping("/singer")
public class SingerService {
    @Autowired
    SingerDaoImpl singerDao;

    @Autowired
    private Environment env;

    //@GetMapping("/listar")
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    List<Singer> findAll() {
        return singerDao.findAll();
    }

    @PostMapping("/insertar")
    Singer save(@RequestBody Singer singer) {
        return singerDao.save(singer);
    }

    @GetMapping(path="/test")
    public String test() {
        return env.getProperty( "server.port" );
    }


}
