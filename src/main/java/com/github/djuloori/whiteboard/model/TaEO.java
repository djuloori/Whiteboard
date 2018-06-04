package com.github.djuloori.whiteboard.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dhruva Juloori on 11/22/2017.
 */
@Entity
@Table(name = "ta", schema = "project_515")
@NamedQuery(name="TaEntity.findAll", query="Select t from TaEO t")
public class TaEO implements Serializable{
    @Id
    @Column(name = "ta_id", nullable = false, length = 45)
    private String taId;

    @Basic
    @Column(name = "ta_name", nullable = true, length = 45)
    private String taName;

    @Basic
    @Column(name = "ta_email", nullable = true, length = 45)
    private String taEmail;

    @Basic
    @Column(name = "ta_phone", nullable = true, length = 45)
    private String taPhone;

    @Basic
    @Column(name = "ta_timings", nullable = true, length = 45)
    private String taTimings;

    @Basic
    @Column(name = "day", nullable = true, length = 45)
    private String day;

    @Column(name = "CLASS_ID",nullable = true)
    private String classId;

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name ="class_id")
    private ClassesEO classesEO;

    public ClassesEO getCle2() {
        return classesEO;
    }

    public void setCle2(ClassesEO classesEO) {
        this.classesEO = classesEO;
    }


    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }


    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }


    public String getTaEmail() {
        return taEmail;
    }

    public void setTaEmail(String taEmail) {
        this.taEmail = taEmail;
    }


    public String getTaPhone() {
        return taPhone;
    }

    public void setTaPhone(String taPhone) {
        this.taPhone = taPhone;
    }

    public String getTaTimings() {
        return taTimings;
    }

    public void setTaTimings(String taTimings) {
        this.taTimings = taTimings;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
