package Model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Dhruva Juloori on 11/22/2017.
 */
@Entity
@Table(name = "ta", schema = "project_515")
@NamedQuery(name="TaEntity.findAll", query="Select t from TaEntity t")
public class TaEntity implements Serializable{
    @Id
    @Column(name = "ta_id", nullable = false, length = 45)
    private String taId;

    @Basic
    @Column(name = "ta_name", nullable = true, length = 45)
    private String taName;

    @Basic
    @Column(name = "ta_email", nullable = true, length = 45)
    private String taEmail;

    @Basic
    @Column(name = "ta_phone", nullable = true, length = 45)
    private String taPhone;

    @Basic
    @Column(name = "ta_timings", nullable = true, length = 45)
    private String taTimings;

    @Basic
    @Column(name = "day", nullable = true, length = 45)
    private String day;

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
    private ClassesEntity cle2;

    public ClassesEntity getCle2() {
        return cle2;
    }

    public void setCle2(ClassesEntity cle2) {
        this.cle2 = cle2;
    }


    public String getTaId() {
        return taId;
    }

    public void setTaId(String taId) {
        this.taId = taId;
    }


    public String getTaName() {
        return taName;
    }

    public void setTaName(String taName) {
        this.taName = taName;
    }


    public String getTaEmail() {
        return taEmail;
    }

    public void setTaEmail(String taEmail) {
        this.taEmail = taEmail;
    }


    public String getTaPhone() {
        return taPhone;
    }

    public void setTaPhone(String taPhone) {
        this.taPhone = taPhone;
    }

    public String getTaTimings() {
        return taTimings;
    }

    public void setTaTimings(String taTimings) {
        this.taTimings = taTimings;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
