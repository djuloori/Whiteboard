package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.StudentEO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class StudentDao {

    //@Huh - Shouldn't do in this way [Change in the next tag]
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List getAllStudents(){
        em.getTransaction().begin();
        Query s_q = em.createNamedQuery("StudentEntity.findAll", StudentEO.class);
        List<StudentEO> se;
        se = s_q.getResultList();
        return se;
    }
}