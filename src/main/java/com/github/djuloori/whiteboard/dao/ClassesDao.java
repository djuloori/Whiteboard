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
            ClassesEO course = new ClassesEO();
            course.setClassId(classesRO.getClassId());
            course.setClassName(classesRO.getClassName());
            course.setUsername(classesRO.getUserName());
            em.getTransaction().begin();
            em.persist(course);
            em.getTransaction().commit();
            return "Inserted";
        }catch (Exception e){
            return "Not Inserted";
        }
    }

    public List getAllCourses() {
        em.getTransaction().begin();
        Query query = em.createNamedQuery("ClassesEntity.findAll",ClassesEO.class);
        List<ClassesEO> courseList = query.getResultList();
        return courseList;
    }

    public String editClass(ClassesRO classesRO) {
        try {
            ClassesEO course = new ClassesEO();
            course.setClassId(classesRO.getClassId());
            course.setClassName(classesRO.getClassName());
            course.setUsername(classesRO.getUserName());
            em.getTransaction().begin();
            em.merge(course);
            em.getTransaction().commit();
            return "Edited";
        } catch (Exception e) {
            return "Not Edited";
        }
    }

    public String removeClass(ClassesRO classesRO){
        try {
            em.getTransaction().begin();
            ClassesEO course = em.find(ClassesEO.class,classesRO.getClassId());
            em.remove(course);
            em.getTransaction().commit();
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
