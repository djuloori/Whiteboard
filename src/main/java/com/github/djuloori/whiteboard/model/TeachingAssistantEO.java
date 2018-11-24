package com.github.djuloori.whiteboard.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dhruva Juloori on 11/22/2017.
 */
@Entity
@Table(name = "ta", schema = "project_515")
@NamedQuery(name="TaEntity.findAll", query="Select t from TeachingAssistantEO t")
public class TeachingAssistantEO implements Serializable{
    @Id
    @Column(name = "ta_id", nullable = false, length = 45)
    private String Id;

    @Basic
    @Column(name = "ta_name", nullable = true, length = 45)
    private String Name;

    @Basic
    @Column(name = "ta_email", nullable = true, length = 45)
    private String Email;

    @Basic
    @Column(name = "ta_phone", nullable = true, length = 45)
    private String Phone;

    @Basic
    @Column(name = "ta_timings", nullable = true, length = 45)
    private String Timings;

    @Basic
    @Column(name = "day", nullable = true, length = 45)
    private String day;

    @Column(name = "CLASS_ID",nullable = true)
    private String classId;
    public String getClassId() { return classId; }

    public void setClassId(String classId) { this.classId = classId; }

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name ="class_id")
    private ClassesEO classesEO;

    public ClassesEO getCle2() {  return classesEO; }

    public void setCle2(ClassesEO classesEO) { this.classesEO = classesEO; }

    public String getId() { return Id; }

    public void setId(String id) {  this.Id = id; }

    public String getName() {   return Name; }

    public void setName(String name) {  this.Name = name; }

    public String getEmail() {  return Email; }

    public void setEmail(String email) {  this.Email = email; }

    public String getPhone() {  return Phone; }

    public void setPhone(String phone) {  this.Phone = phone; }

    public String getTimings() {  return Timings; }

    public void setTimings(String timings) {  this.Timings = timings; }

    public String getDay() {  return day; }

    public void setDay(String day) {  this.day = day; }
}
