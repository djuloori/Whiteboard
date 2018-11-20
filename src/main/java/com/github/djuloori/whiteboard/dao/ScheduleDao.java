package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.SecurableEntityManager;
import com.github.djuloori.whiteboard.framework.SecurableEntityManagerImpl;
import com.github.djuloori.whiteboard.model.ScheduleEO;
import com.github.djuloori.whiteboard.rest.ScheduleRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class ScheduleDao {

    @Autowired
    private SecurableEntityManager m_SecurableEntityManager;

    @Transactional
    public List getAllschedule(){
        Query query = m_SecurableEntityManager.createQuery("ScheduleEntity.findAll", ScheduleEO.class);
        List<ScheduleEO> scheduleList = query.getResultList();
        return scheduleList;
    }

    @Transactional
    public String addSchedule(ScheduleRO scheduleRO){
        try {
            ScheduleEO schedule = new ScheduleEO();
            schedule.setTimings(scheduleRO.getTimings());
            schedule.setDay(scheduleRO.getDay());
            schedule.setLocation(scheduleRO.getLocation());
            schedule.setClassId(scheduleRO.getCLASS_ID());
            schedule.setScheduleId(scheduleRO.getScheduleId());
            m_SecurableEntityManager.save(schedule);
            return "Schedule Added";
        }catch (Exception e){
            return "not done";
        }
    }

    @Transactional
    public String editSchedule(ScheduleRO scheduleRO){
        try {
            ScheduleEO schedule = new ScheduleEO();
            schedule.setTimings(scheduleRO.getTimings());
            schedule.setDay(scheduleRO.getDay());
            schedule.setLocation(scheduleRO.getLocation());
            schedule.setClassId(scheduleRO.getCLASS_ID());
            schedule.setScheduleId(scheduleRO.getScheduleId());
            m_SecurableEntityManager.update(schedule);
            return "Schedule Edited";
        }catch (Exception e){
            return "not done";
        }
    }

    @Transactional
    public String removeSchedule(ScheduleRO scheduleRO){
        try {
            m_SecurableEntityManager.delete(ScheduleEO.class,scheduleRO.getScheduleId());
            return "Schedule Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}