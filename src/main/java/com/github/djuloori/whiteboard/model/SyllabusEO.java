package com.github.djuloori.whiteboard.model;

import javax.persistence.*;

@Entity
@Table(name = "syllabus", schema = "project_515")
@NamedQuery(name="SyllabusEntity.findAll", query="Select s from SyllabusEO s ")
public class SyllabusEO {
    //variables
    @Basic
    @Column(name = "syllabus", nullable = true)
    private byte[] syllabus;

    @Id
    @Column(name = "idsyllabus", nullable = false, length = 45)
    private String syllabusId;

    @Column(name = "class_id",nullable = true)
    private String classId;

    //getter and setter methods
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public byte[] getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(byte[] syllabus) {
        this.syllabus = syllabus;
    }


    public String getSyllabusId() {
        return syllabusId;
    }

    public void setSyllabusId(String syllabusId) {
        this.syllabusId = syllabusId;
    }

}
