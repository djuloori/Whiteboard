package Dao;

import Model.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class StudentDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();
    public List getAllStudents(){
        em.getTransaction().begin();
        Query s_q = em.createNamedQuery("StudentEntity.findAll", StudentEntity.class);
        List<StudentEntity> se;
        se = s_q.getResultList();
        return se;
    }
}