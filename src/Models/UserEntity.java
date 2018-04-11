package Models;

import Models.ClassesEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Dhruva Juloori on 11/22/2017.
 */
@Entity
@Table(name = "user", schema = "project_515")
@NamedQueries({@NamedQuery(name="UserEntity.findAll", query="Select u from UserEntity u"),
        @NamedQuery(name="UserEntity.Validation",query="Select u from UserEntity u where u.username = :username and u.password = :password")})
public class UserEntity implements Serializable{
    @Id
    @Column(name = "username", nullable = false, updatable = false, length = 45)
    private String username;

    @Basic
    @Column(name = "password", nullable = true, length = 45)
    private String password;

    @Basic
    @Column(name = "usertype", nullable = true, length = 45)
    private String usertype;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_name")
    private List<ClassesEntity> classes;

    public List<ClassesEntity> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassesEntity> classes) {
        this.classes = classes;
    }


}
