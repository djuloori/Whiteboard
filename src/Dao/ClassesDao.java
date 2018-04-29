package Dao;

import Model.ClassesEO;
import Model.UserEO;
import Rest.ClassesRO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class ClassesDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();


    public String addClass(ClassesRO classesRO){
        ClassesEO ce = new ClassesEO();
        ce.setClassId(classesRO.getClassId());
        ce.setClassName(classesRO.getClassName());
        ce.setUSER_NAME(classesRO.getUserName());
        em.getTransaction().begin();
        em.persist(ce);
        try {
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
        //UserEO user = new UserEO();
        //user.setUsername(username);
        ClassesEO ce = new ClassesEO();
        ce.setClassId(classesRO.getClassId());
        ce.setClassName(classesRO.getClassName());
        ce.setUSER_NAME(classesRO.getUserName());
        em.getTransaction().begin();
        em.merge(ce);
        try {
            em.getTransaction().commit();
            return "Edited";
        } catch (Exception e) {
            return "Not Edited";
        }
    }

    public String removeClass(ClassesRO classesRO){
        em.getTransaction().begin();
        ClassesEO ce = em.find(ClassesEO.class,classesRO.getClassId());
        em.remove(ce);
        try {
            em.getTransaction().commit();
            return "Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}
