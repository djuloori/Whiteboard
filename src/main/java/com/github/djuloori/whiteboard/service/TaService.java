package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.TaDao;
import com.github.djuloori.whiteboard.model.TeachingAssistantEO;
import com.github.djuloori.whiteboard.rest.TaRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaService {

    @Autowired
    private TaDao taDao;

    public String syncTa(TaRO taRO){
        TeachingAssistantEO ta = new TeachingAssistantEO();
        ta.setId(taRO.getTaId());
        ta.setName(taRO.getTaName());
        ta.setEmail(taRO.getTaEmail());
        ta.setPhone(taRO.getTaPhone());
        ta.setTimings(taRO.getTaTimings());
        ta.setClassId(taRO.getCLASS_ID());
        ta.setDay(taRO.getDay());
        return taDao.addTa(ta);
    }

    public String removeTa(String id){
        return taDao.removeTa(id);
    }

}
