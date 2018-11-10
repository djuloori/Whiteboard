package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.SyllabusEO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
public class SyllabusDao {

    //@Huh - Shouldn't do in this way [Change in the next tag]
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List getAllSyllubus(){
        em.getTransaction().begin();
        Query s_q = em.createNamedQuery("SyllabusEntity.findAll", SyllabusEO.class);;
        List<SyllabusEO> se = s_q.getResultList();
        return se;
    }

    public String addsyllubus(String class_id, InputStream inputStream, String syllabusid) throws IOException {
        try {
            SyllabusEO syllabus = new SyllabusEO();
            syllabus.setClassId(class_id);
            syllabus.setIdsyllabus(syllabusid);
            syllabus.setSyllabus(org.apache.commons.io.IOUtils.toByteArray(inputStream));
            em.getTransaction().begin();
            em.persist(syllabus);
            em.getTransaction().commit();
            return "done";
        }catch (Exception e){
            return "not done";
        }
    }

    public String removeSyllabus(String syllabus_id){
        try {
            em.getTransaction().begin();
            SyllabusEO syllabus = em.find(SyllabusEO.class,syllabus_id);
            em.remove(syllabus);
            em.getTransaction().commit();
            return "Syllabus Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}