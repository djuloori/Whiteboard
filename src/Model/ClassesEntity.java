package Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "classes", schema = "project_515")
@NamedQuery(name="ClassesEntity.findAll", query="Select c from ClassesEntity c")
public class ClassesEntity {
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
    private UserEntity usr;

    public UserEntity getUsr() {
        return usr;
    }

    public void setUsr(UserEntity usr) {
        this.usr = usr;
    }

    @Override
    public String toString() {
        return "ClassesEntity{" + "classId='" + classId + '\'' + ", className='" + className + '\'' + ", USER_NAME='" + USER_NAME + '\'' + ", usr=" + usr + '}';
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="class_id")
    private List<StudentEntity> students;

    public List<StudentEntity> getStudents() {
        return students;
    }

    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="class_id")
    private List<TaEntity> taEntities;

    public List<TaEntity> getTaEntities() {
        return taEntities;
    }

    public void setTaEntities(List<TaEntity> taEntities) {
        this.taEntities = taEntities;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="class_id")
    private List<AssignmentEntity> assignmentEntities;

    public List<AssignmentEntity> getAssignmentEntities() {
        return assignmentEntities;
    }

    public void setAssignmentEntities(List<AssignmentEntity> assignmentEntities) {
        this.assignmentEntities = assignmentEntities;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="class_id")
    private ScheduleEntity scheduleEntity;

    public ScheduleEntity getScheduleEntity() {
        return scheduleEntity;
    }

    public void setScheduleEntity(ScheduleEntity scheduleEntity) {
        this.scheduleEntity = scheduleEntity;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name="class_id")
    private SyllabusEntity syllabusEntity;

    public SyllabusEntity getSyllabusEntity() {
        return syllabusEntity;
    }

    public void setSyllabusEntity(SyllabusEntity syllabusEntity) {
        this.syllabusEntity = syllabusEntity;
    }
}
