package com.spring.dao;

import com.spring.entidad.Singer;

import java.util.List;

public interface SingerDao{
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    Singer update(Singer singer);
    Integer delete(Singer singer);
}
