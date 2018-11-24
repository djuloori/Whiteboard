package com.github.djuloori.whiteboard.model;

import javax.persistence.*;

/**
 * Created by Dhruva Juloori on 12/1/2017.
 */
@Entity
@Table(name = "schedule", schema = "project_515")
@NamedQuery(name="ScheduleEntity.findAll", query="Select s from ScheduleEO s")
public class ScheduleEO {
    @Basic
    @Column(name = "timings", nullable = true, length = 45)
    private String timings;

    @Basic
    @Column(name = "location", nullable = true, length = 45)
    private String location;

    @Id
    @Column(name = "schedule_id", nullable = false, length = 45)
    private String scheduleId;

    @Column(name = "CLASS_ID",nullable = true)
    private String classId;

    @Basic
    @Column(name = "day", nullable = true, length = 45)
    private String day;
    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(String scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
