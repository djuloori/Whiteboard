package Dao;

import Model.TaEO;
import Rest.TaRO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class TaDao {

    //@Huh - Shouldn't do in this way [Change in the next tag]
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List getAllTa(){
        em.getTransaction().begin();
        Query t_a = em.createNamedQuery("TaEntity.findAll", TaEO.class);
        List<TaEO> ts;
        ts  = t_a.getResultList();
        return ts;
    }

    public String addTa(TaRO taRO){
       TaEO ta = new TaEO();
       ta.setTaId(taRO.getTaId());
       ta.setTaName(taRO.getTaName());
       ta.setTaEmail(taRO.getTaEmail());
       ta.setTaPhone(taRO.getTaPhone());
       ta.setTaTimings(taRO.getTaTimings());
       ta.setCLASS_ID(taRO.getCLASS_ID());
       ta.setDay(taRO.getDay());
        em.getTransaction().begin();
        em.persist(ta);
        try {
            em.getTransaction().commit();
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
            return "Ta Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }


}