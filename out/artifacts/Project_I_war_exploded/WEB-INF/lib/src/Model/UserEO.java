package Model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user", schema = "project_515")
@NamedQueries({@NamedQuery(name="UserEntity.findAll", query="Select u from UserEO u"),
        @NamedQuery(name="UserEntity.Validation",query="Select u from UserEO u where u.username = :username and u.password = :password")})
public class UserEO implements Serializable{
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
    private List<ClassesEO> classList;

    public List<ClassesEO> getClasses() {
        return classList;
    }

    public void setClasses(List<ClassesEO> classes) {
        this.classList = classList;
    }


}
