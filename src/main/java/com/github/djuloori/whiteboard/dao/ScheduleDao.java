package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.model.ScheduleEO;
import com.github.djuloori.whiteboard.rest.ScheduleRO;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Component
public class ScheduleDao{

    //@Huh - Shouldn't do in this way [Change in the next tag]
    EntityManagerFactory emf =  Persistence.createEntityManagerFactory("PersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public List getAllschedule(){
        em.getTransaction().begin();
        Query query = em.createNamedQuery("ScheduleEntity.findAll", ScheduleEO.class);
        List<ScheduleEO> scheduleList = query.getResultList();
        return scheduleList;
    }

    public String addSchedule(ScheduleRO scheduleRO){
        try {
            ScheduleEO schedule = new ScheduleEO();
            schedule.setTimings(scheduleRO.getTimings());
            schedule.setDay(scheduleRO.getDay());
            schedule.setLocation(scheduleRO.getLocation());
            schedule.setClassId(scheduleRO.getCLASS_ID());
            schedule.setScheduleId(scheduleRO.getScheduleId());
            em.getTransaction().begin();
            em.persist(schedule);
            em.getTransaction().commit();
            return "Schedule Added";
        }catch (Exception e){
            return "not done";
        }
    }

    public String editSchedule(ScheduleRO scheduleRO){
        try {
            ScheduleEO schedule = new ScheduleEO();
            schedule.setTimings(scheduleRO.getTimings());
            schedule.setDay(scheduleRO.getDay());
            schedule.setLocation(scheduleRO.getLocation());
            schedule.setClassId(scheduleRO.getCLASS_ID());
            schedule.setScheduleId(scheduleRO.getScheduleId());
            em.getTransaction().begin();
            em.merge(schedule);
            em.getTransaction().commit();
            return "Schedule Edited";
        }catch (Exception e){
            return "not done";
        }
    }

    public String removeSchedule(ScheduleRO scheduleRO){
        try {
            em.getTransaction().begin();
            ScheduleEO schedule = em.find(ScheduleEO.class,scheduleRO.getScheduleId());
            em.remove(schedule);
            em.getTransaction().commit();
            return "Schedule Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}