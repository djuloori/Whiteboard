package com.github.djuloori.whiteboard.service;

import com.github.djuloori.whiteboard.dao.ScheduleDao;
import com.github.djuloori.whiteboard.model.ScheduleEO;
import com.github.djuloori.whiteboard.rest.ScheduleRO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    public String syncSchedule(ScheduleRO scheduleRO){
        ScheduleEO schedule = new ScheduleEO();
        schedule.setTimings(scheduleRO.getTimings());
        schedule.setDay(scheduleRO.getDay());
        schedule.setLocation(scheduleRO.getLocation());
        schedule.setClassId(scheduleRO.getCLASS_ID());
        schedule.setScheduleId(scheduleRO.getScheduleId());
        return scheduleDao.addSchedule(schedule);
    }

    public String modifySchedule(ScheduleRO scheduleRO){
        ScheduleEO schedule = new ScheduleEO();
        schedule.setTimings(scheduleRO.getTimings());
        schedule.setDay(scheduleRO.getDay());
        schedule.setLocation(scheduleRO.getLocation());
        schedule.setClassId(scheduleRO.getCLASS_ID());
        schedule.setScheduleId(scheduleRO.getScheduleId());
        return scheduleDao.editSchedule(schedule);
    }

    public String removeSchedule(String scheduleId){
        ScheduleEO schedule = new ScheduleEO();
        schedule.setScheduleId(scheduleId);
        return scheduleDao.removeSchedule(schedule);
    }

}
