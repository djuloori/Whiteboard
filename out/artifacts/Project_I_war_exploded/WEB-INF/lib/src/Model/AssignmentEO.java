package Model;

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


    @Column(nullable = true)
    private String CLASS_ID;

    public String getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(String CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn(name ="class_id")
    private ClassesEO cle;

    public ClassesEO getCle() {
        return cle;
    }

    public void setCle(ClassesEO cle) {
        this.cle = cle;
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
