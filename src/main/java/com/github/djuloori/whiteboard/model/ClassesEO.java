package com.github.djuloori.whiteboard.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes", schema = "project_515")
@NamedQuery(name="ClassesEntity.findAll", query="Select c from ClassesEO c")
public class ClassesEO {
    @Id
    @Column(name = "class_id", nullable = false, length = 45)
    private String classId;

    @Basic
    @Column(name = "class_name", nullable = true, length = 45)
    private String className;

    @Column(name = "USER_NAME", nullable = true)
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name ="user_name")
    private UserEO userEO;

    public UserEO getUsr() {
        return userEO;
    }

    public void setUsr(UserEO userEO) {
        this.userEO = userEO;
    }


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="class_id")
    private List<StudentEO> students;

    public List<StudentEO> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEO> students) {
        this.students = students;
    }

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="class_id")
    private List<TeachingAssistantEO> taEntities;

    public List<TeachingAssistantEO> getTaEntities() {
        return taEntities;
    }

    public void setTaEntities(List<TeachingAssistantEO> taEntities) {
        this.taEntities = taEntities;
    }

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name="class_id")
    private List<AssignmentEO> assignmentEntities;

    public List<AssignmentEO> getAssignmentEntities() {
        return assignmentEntities;
    }

    public void setAssignmentEntities(List<AssignmentEO> assignmentEntities) {
        this.assignmentEntities = assignmentEntities;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="class_id")
    private ScheduleEO scheduleEntity;

    public ScheduleEO getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEO scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="class_id")
    private SyllabusEO syllabusEntity;

    public SyllabusEO getSyllabusEntity() {
        return syllabusEntity;
    }

    public void setSyllabusEntity(SyllabusEO syllabusEntity) {
        this.syllabusEntity = syllabusEntity;
    }
}
