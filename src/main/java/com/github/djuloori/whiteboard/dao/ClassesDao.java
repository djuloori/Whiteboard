package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.ClassesEO;
import com.github.djuloori.whiteboard.rest.ClassesRO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class ClassesDao {

    //@Huh - Shouldn't do in this way [Change in the next tag]
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();


    public String addClass(ClassesRO classesRO){
        try {
            ClassesEO ce = new ClassesEO();
            ce.setClassId(classesRO.getClassId());
            ce.setClassName(classesRO.getClassName());
            ce.setUsername(classesRO.getUserName());
            em.getTransaction().begin();
            em.persist(ce);
            em.getTransaction().commit();
            return "Inserted";
        }catch (Exception e){
            return "Not Inserted";
        }
    }

    public List getAllCourses() {
        em.getTransaction().begin();
        Query q = em.createNamedQuery("ClassesEntity.findAll",ClassesEO.class);
        List<ClassesEO> cs;
        cs = q.getResultList();
        return cs;
    }

    public String editClass(ClassesRO classesRO) {
        try {
            ClassesEO ce = new ClassesEO();
            ce.setClassId(classesRO.getClassId());
            ce.setClassName(classesRO.getClassName());
            ce.setUsername(classesRO.getUserName());
            em.getTransaction().begin();
            em.merge(ce);
            em.getTransaction().commit();
            return "Edited";
        } catch (Exception e) {
            return "Not Edited";
        }
    }

    public String removeClass(ClassesRO classesRO){
        try {
            em.getTransaction().begin();
            ClassesEO ce = em.find(ClassesEO.class,classesRO.getClassId());
            em.remove(ce);
            em.getTransaction().commit();
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
