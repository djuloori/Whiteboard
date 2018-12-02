package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.model.SyllabusEO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class SyllabusDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public List getAllSyllubus(){
        Query query = m_SecurableEntityManager.createQuery("SyllabusEntity.findAll", SyllabusEO.class);;
        List<SyllabusEO> syllabusList = query.getResultList();
        return syllabusList;
    }

    @Transactional
    public String addsyllubus(SyllabusEO syllabus) throws IOException {
        try {
            m_SecurableEntityManager.save(syllabus);
            return "done";
        }catch (Exception e){
            return "not done";
        }
    }

    @Transactional
    public String removeSyllabus(String syllabusId){
        try {
            m_SecurableEntityManager.delete(SyllabusEO.class,syllabusId);
            return "Syllabus Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}