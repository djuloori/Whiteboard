package com.github.djuloori.whiteboard.model;

import javax.persistence.*;

import java.io.Serializable;

/**
 * Created by Dhruva Juloori on 11/22/2017.
 */
@Entity
@Table(name = "student", schema = "project_515")
@NamedQuery(name="StudentEntity.findAll", query="Select s from StudentEO s")
public class StudentEO implements Serializable {
    //variables
    @Id
    @Column(name = "student_id", nullable = false, length = 45)
    private String studentId;

    @Basic
    @Column(name = "student_name", nullable = true, length = 45)
    private String studentName;

    @Basic
    @Column(name = "student_email", nullable = true, length = 45)
    private String studentEmail;

    @Basic
    @Column(name = "student_phno", nullable = true, length = 45)
    private String studentPhoneNumber;

    @Column(name = "CLASS_ID",nullable = true)
    private String classId;
    //getter and setter methods
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name ="class_id")
    private ClassesEO classesEO;

    public ClassesEO getClassesEO() {
        return classesEO;
    }

    public void setClassesEO(ClassesEO classesEO) {
        this.classesEO = classesEO;
    }
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }


    public String getStudentPhoneNumber() {
        return studentPhoneNumber;
    }

    public void setStudentPhoneNumber(String studentPhoneNumber) {
        this.studentPhoneNumber = studentPhoneNumber;
    }

}
