package com.spring.controller;

import com.spring.entidad.Instrument;
import com.spring.service.InstrumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class InstrumentAction {
    @ManagedProperty("#{instrumentService}")

    private InstrumentServiceImpl instrumentService;
    private Instrument instrument;
    private List<Instrument> instruments;

    @PostConstruct
    private void postConstruct() {
        instrumentService = new InstrumentServiceImpl();
        instrument = new Instrument();
        instruments = instrumentService.findAll();
    }

    public InstrumentServiceImpl getInstrumentService() {
        return instrumentService;
    }

    public void setInstrumentService(InstrumentServiceImpl instrumentService) {
        this.instrumentService = instrumentService;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public void save(){
        instrumentService.save(instrument);
        try {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().redirect("/instrument/index.xhtml");
        } catch (Exception e) {
        }
    }
}
