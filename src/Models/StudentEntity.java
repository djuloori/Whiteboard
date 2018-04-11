package Models;

import javax.persistence.*;
import java.util.Objects;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dhruva Juloori on 11/22/2017.
 */
@Entity
@Table(name = "student", schema = "project_515")
@NamedQuery(name="StudentEntity.findAll", query="Select s from StudentEntity s")
public class StudentEntity implements Serializable {
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
    private String studentPhno;

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
    private ClassesEntity cle1;

    public ClassesEntity getCle1() {
        return cle1;
    }

    public void setCle1(ClassesEntity cle1) {
        this.cle1 = cle1;
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


    public String getStudentPhno() {
        return studentPhno;
    }

    public void setStudentPhno(String studentPhno) {
        this.studentPhno = studentPhno;
    }

}
