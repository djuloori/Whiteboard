package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.TaEO;
import com.github.djuloori.whiteboard.rest.TaRO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class TaDao extends AbstractDao {

    @Transactional
    public List getAllTa(){
        Query query = createQuery("TaEntity.findAll", TaEO.class);
        List<TaEO> taList = query.getResultList();
        return taList;
    }

    @Transactional
    public String addTa(TaRO taRO){
        try {
            TaEO ta = new TaEO();
            ta.setTaId(taRO.getTaId());
            ta.setTaName(taRO.getTaName());
            ta.setTaEmail(taRO.getTaEmail());
            ta.setTaPhone(taRO.getTaPhone());
            ta.setTaTimings(taRO.getTaTimings());
            ta.setClassId(taRO.getCLASS_ID());
            ta.setDay(taRO.getDay());
            save(ta);
            return "Ta Added";
        }catch (Exception e){
            return "Not Added";
        }
    }

    @Transactional
    public String removeTa(String taId){
        try {
            delete(TaEO.class,taId);
            return "Ta Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }


}