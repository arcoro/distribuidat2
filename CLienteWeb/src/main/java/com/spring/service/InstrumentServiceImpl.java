package com.spring.service;

import com.spring.entidad.Instrument;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class InstrumentServiceImpl implements InstrumentService {
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Instrument> findAll() {
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:9090/api/instrumentservice/instrument/listar", List.class);
        return list.getBody();
    }

    @Override
    public void save(Instrument instrument) {
        ResponseEntity<Instrument> response = restTemplate.postForEntity("http://localhost:9090/api/instrumentservice/instrument/insertar"
                , instrument, Instrument.class);
    }
}
