package com.spring.controller;


import com.spring.entidad.Singer;
import com.spring.service.SingerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean
@SessionScoped
public class SingerAction {
    @ManagedProperty("#{singerService}")

    private SingerServiceImpl singerService;
    private List<Singer> singers;

    @PostConstruct
    public void init(){
        singerService=new SingerServiceImpl();
        singers = singerService.findAll();
    }

    public SingerServiceImpl getSingerService() {
        return singerService;
    }

    public void setSingerService(SingerServiceImpl singerService) {
        this.singerService = singerService;
    }

    public List<Singer> getSingers() {
        return singers;
    }

    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }
}
