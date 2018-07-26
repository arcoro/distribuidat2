package com.spring.service;

import com.spring.entidad.Singer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;


public class SingerServiceImpl implements SingerService {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Singer> findAll() {
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:9090/api/singer-cloud/singer/listar", List.class);
        return list.getBody();
    }
}
