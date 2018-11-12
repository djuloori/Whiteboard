package com.github.djuloori.whiteboard.dao;

import com.github.djuloori.whiteboard.framework.EntityManagerService;
import com.github.djuloori.whiteboard.model.ScheduleEO;
import com.github.djuloori.whiteboard.rest.ScheduleRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Component
public class ScheduleDao extends AbstractDao{

    @Transactional
    public List getAllschedule(){
        Query query = createQuery("ScheduleEntity.findAll", ScheduleEO.class);
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
            save(schedule);
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
            update(schedule);
            return "Schedule Edited";
        }catch (Exception e){
            return "not done";
        }
    }

    @Transactional
    public String removeSchedule(ScheduleRO scheduleRO){
        try {
            delete(ScheduleEO.class,scheduleRO.getScheduleId());
            return "Schedule Removed";
        }catch (Exception e){
            return "Not Removed";
        }
    }
}