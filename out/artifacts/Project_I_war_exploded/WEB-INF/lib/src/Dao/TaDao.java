package Dao;

import Model.TaEO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class TaDao {
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List getAllTa(){
        em.getTransaction().begin();
        Query t_a = em.createNamedQuery("TaEntity.findAll", TaEO.class);
        List<TaEO> ts;
        ts  = t_a.getResultList();
        return ts;
    }

    public String addTa(String ta_id, String ta_name, String ta_email, String ta_phone, String ta_timings, String class_id, String day){
       TaEO ta = new TaEO();
       ta.setTaId(ta_id);
       ta.setTaName(ta_name);
       ta.setTaEmail(ta_email);
       ta.setTaPhone(ta_phone);
       ta.setTaTimings(ta_timings);
       ta.setCLASS_ID(class_id);
       ta.setDay(day);
        em.getTransaction().begin();
        em.persist(ta);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return "Ta Added";
        }catch (Exception e){
            return "Not Added";
        }
    }

    public String removeTa(String ta_id){
        em.getTransaction().begin();
        TaEO te = em.find(TaEO.class,ta_id);
        em.remove(te);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return "Ta Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }


}