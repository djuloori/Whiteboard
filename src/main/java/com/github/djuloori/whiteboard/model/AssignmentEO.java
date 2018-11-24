package com.github.djuloori.whiteboard.model;

import javax.persistence.*;

/**
 * Created by Dhruva Juloori on 11/27/2017.
 */
@Entity
@Table(name = "assignment", schema = "project_515")
@NamedQuery(name="AssignmentsEntity.findAll", query="Select a from AssignmentEO a")
public class AssignmentEO {
    @Id
    @Column(name = "assignment_id", nullable = false, length = 45)
    private String assignmentId;

    @Basic
    @Column(name = "assignment_name", nullable = true, length = 45)
    private String assignmentName;

    @Basic
    @Column(name = "total_points", nullable = true, length = 45)
    private String totalPoints;

    @Basic
    @Column(name = "Assignment", nullable = true)
    private byte[] assignment;


    @Column(name = "class_id",nullable = true)
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

    public ClassesEO getCourses() {
        return classesEO;
    }

    public void setCourses(ClassesEO classesEO) {
        this.classesEO = classesEO;
    }

    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(String totalPoints) {
        this.totalPoints = totalPoints;
    }

    public byte[] getAssignment() {
        return assignment;
    }

    public void setAssignment(byte[] assignment) {
        this.assignment = assignment;
    }

}
