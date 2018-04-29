package Dao;

import Model.SyllabusEO;
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
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();
    public List getAllSyllubus(){
        em.getTransaction().begin();
        Query s_q = em.createNamedQuery("SyllabusEntity.findAll", SyllabusEO.class);;
        List<SyllabusEO> se = s_q.getResultList();
        return se;
    }

    public String addsyllubus(String class_id, InputStream inputStream, String syllabusid) throws IOException {
        SyllabusEO syllubusEntity = new SyllabusEO();
        syllubusEntity.setCLASS_ID(class_id);
        syllubusEntity.setIdsyllabus(syllabusid);
        syllubusEntity.setSyllabus(org.apache.commons.io.IOUtils.toByteArray(inputStream));
        em.getTransaction().begin();
        em.persist(syllubusEntity);
        try {
            em.getTransaction().commit();
            return "done";
        }catch (Exception e){
            return "not done";
        }
    }

    public String removeSyllabus(String syllabus_id){
        em.getTransaction().begin();
        SyllabusEO syllabus = em.find(SyllabusEO.class,syllabus_id);
        em.remove(syllabus);
        try {
            em.getTransaction().commit();
            return "Syllabus Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}