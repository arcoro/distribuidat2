package com.spring.service;

import com.spring.entidad.Album;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class AlbumServiceImpl implements AlbumService {

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Album> findAll() {
        ResponseEntity<List> list = restTemplate.getForEntity("http://localhost:9090/api/albumservice/album/listar", List.class);
        return list.getBody();
    }

}
