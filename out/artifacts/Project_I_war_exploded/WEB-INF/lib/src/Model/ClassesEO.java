package Model;

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

    @Column(nullable = true)
    private String USER_NAME;

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
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
    private UserEO usr;

    public UserEO getUsr() {
        return usr;
    }

    public void setUsr(UserEO usr) {
        this.usr = usr;
    }

    @Override
    public String toString() {
        return "ClassesEntity{" + "classId='" + classId + '\'' + ", className='" + className + '\'' + ", USER_NAME='" + USER_NAME + '\'' + ", usr=" + usr + '}';
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

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="class_id")
    private List<TaEO> taEntities;

    public List<TaEO> getTaEntities() {
        return taEntities;
    }

    public void setTaEntities(List<TaEO> taEntities) {
        this.taEntities = taEntities;
    }

    @OneToMany(cascade=CascadeType.ALL)
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
