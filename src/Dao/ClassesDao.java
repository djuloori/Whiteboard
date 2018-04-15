package Dao;

import Model.ClassesEO;
import Model.UserEO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by Dhruva Juloori on 11/26/2017.
 */
public class ClassesDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();


    public String addClass(String classid, String classname, String username){
        UserEO user = new UserEO();
        user.setUsername(username);
        ClassesEO ce = new ClassesEO();
        ce.setClassId(classid);
        ce.setClassName(classname);
        ce.setUSER_NAME(username);
        em.getTransaction().begin();
        em.persist(ce);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
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

    public String editClass(String classid, String classname, String username) {
        UserEO user = new UserEO();
        user.setUsername(username);
        ClassesEO ce = new ClassesEO();
        ce.setClassId(classid);
        ce.setClassName(classname);
        ce.setUSER_NAME(username);
        em.getTransaction().begin();
        em.merge(ce);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return "Edited";
        } catch (Exception e) {
            return "Not Edited";
        }
    }

    public String removeClass(String classid){
        em.getTransaction().begin();
        ClassesEO ce = em.find(ClassesEO.class,classid);
        em.remove(ce);
        try {
            em.getTransaction().commit();
            System.out.println("Removed");
            em.close();
            emf.close();
            return "Removed";
        }catch (Exception e){
            System.out.println("I am here!");
            return "Not Removed";
        }
    }
}
