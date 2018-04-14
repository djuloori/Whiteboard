package Dao;

import Model.ScheduleEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class ScheduleDao{
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List getAllschedule(){
        em.getTransaction().begin();
        Query q = em.createNamedQuery("ScheduleEntity.findAll", ScheduleEntity.class);
        List<ScheduleEntity> se;
        se = q.getResultList();
        return se;
    }

    public String addSchedule(String timings, String location, String class_id, String schedule_id, String day){
        ScheduleEntity se = new ScheduleEntity();
        se.setTimings(timings);
        se.setDay(day);
        se.setLocation(location);
        se.setCLASS_ID(class_id);
        se.setScheduleId(schedule_id);
        em.getTransaction().begin();
        em.persist(se);
        try {
            em.getTransaction().commit();
            em.close();
            return "Schedule Added";
        }catch (Exception e){
            return "not done";
        }
    }

    public String editSchedule(String timings, String location, String class_id, String schedule_id, String day){
        ScheduleEntity se1 = new ScheduleEntity();
        se1.setTimings(timings);
        se1.setDay(day);
        se1.setLocation(location);
        se1.setCLASS_ID(class_id);
        se1.setScheduleId(schedule_id);
        em.getTransaction().begin();
        em.merge(se1);
        try {
            em.getTransaction().commit();
            em.close();
            return "Schedule Edited";
        }catch (Exception e){
            return "not done";
        }
    }

    public String removeSchedule(String schedule_id){
        em.getTransaction().begin();
        ScheduleEntity se2 = em.find(ScheduleEntity.class,schedule_id);
        em.remove(se2);
        try {
            em.getTransaction().commit();
            em.close();
            emf.close();
            return "Schedule Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}