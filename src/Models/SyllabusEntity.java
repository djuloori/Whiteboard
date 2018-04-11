package Models;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name = "syllabus", schema = "project_515")
@NamedQuery(name="SyllabusEntity.findAll", query="Select s from SyllabusEntity s")
public class SyllabusEntity {
    @Basic
    @Column(name = "syllabus", nullable = true)
    private byte[] syllabus;

    @Id
    @Column(name = "idsyllabus", nullable = false, length = 45)
    private String idsyllabus;

    @Column(nullable = true)
    private String CLASS_ID;

    public String getCLASS_ID() {
        return CLASS_ID;
    }

    public void setCLASS_ID(String CLASS_ID) {
        this.CLASS_ID = CLASS_ID;
    }

    public byte[] getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(byte[] syllabus) {
        this.syllabus = syllabus;
    }


    public String getIdsyllabus() {
        return idsyllabus;
    }

    public void setIdsyllabus(String idsyllabus) {
        this.idsyllabus = idsyllabus;
    }

}
