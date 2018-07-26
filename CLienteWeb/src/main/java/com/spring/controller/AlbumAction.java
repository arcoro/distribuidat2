package com.spring.controller;

import com.spring.entidad.Album;
import com.spring.service.AlbumService;
import com.spring.service.AlbumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.List;

@ManagedBean
@SessionScoped
public class AlbumAction {
    @ManagedProperty("#{albumService}")

    private AlbumServiceImpl albumService;
    private List<Album> albums;

    @PostConstruct
    private void init() {
        albumService = new AlbumServiceImpl();
        albums=albumService.findAll();

    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    public AlbumServiceImpl getAlbumService() {
        return albumService;
    }

    public void setAlbumService(AlbumServiceImpl albumService) {
        this.albumService = albumService;
    }
}
