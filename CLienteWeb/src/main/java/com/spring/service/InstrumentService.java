package com.spring.service;

import com.spring.entidad.Instrument;

import java.util.List;

public interface InstrumentService{
    List<Instrument> findAll();
    void save(Instrument instrument);
}
