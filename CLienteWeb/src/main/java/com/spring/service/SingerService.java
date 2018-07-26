package com.spring.service;

import com.spring.entidad.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
}