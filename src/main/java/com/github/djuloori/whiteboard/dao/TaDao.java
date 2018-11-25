package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.TeachingAssistantEO;
import com.github.djuloori.whiteboard.rest.TaRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class TaDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public List getAllTa(){
        Query query = m_SecurableEntityManager.createQuery("TaEntity.findAll", TeachingAssistantEO.class);
        List<TeachingAssistantEO> taList = query.getResultList();
        return taList;
    }

    @Transactional
    public String addTa(TeachingAssistantEO ta){
        try {
            m_SecurableEntityManager.save(ta);
            return "Ta Added";
        }catch (Exception e){
            return "Not Added";
        }
    }

    @Transactional
    public String removeTa(String taId){
        try {
            m_SecurableEntityManager.delete(TeachingAssistantEO.class,taId);
            return "Ta Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }

}