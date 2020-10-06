package Model;


import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class User implements Serializable {
    private static final long serialVersionUID =1L;
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            @Basic(optional = false)
            @Column(name="id",nullable = false)

    private Long user_id;
    @Column(name = "username", length = 50)
    private String username;
    @Column(name = "password", length = 50)
    private String password;
    @Column(name = "fullname", length = 50)
    private String fullname;
    @Column(name = "email", length = 50)
    private String email;

    @OneToMany(mappedBy ="User" ,fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = false)
    private List<Order> orderEntities;
    @Column(name = "created_at")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @PrePersist
    private void prePersist(){createdAt=new Date();}
    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long id) {
        this.user_id = id;
    }

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



    public String getFullname() {
        return fullname;
    }

    public void setFullname(String name) {
        this.fullname = name;
    }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }
@Override
public int hashCode(){
        int hash =0;
        hash+=(user_id!=null? user_id.hashCode():0);
        return hash;
}
public String toString(){
        return "User{"+"name='"+fullname+'\'' + '}';
}

}
