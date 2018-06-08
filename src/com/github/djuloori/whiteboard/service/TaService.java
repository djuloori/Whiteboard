package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.TaDao;
import com.github.djuloori.whiteboard.rest.TaRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaService {

    @Autowired
    private TaDao taDao;


    public String syncTa(TaRO taRO){
        return taDao.addTa(taRO);
    }

    public String removeTa(String id){
        return taDao.removeTa(id);
    }

}
