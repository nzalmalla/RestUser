package Model;


import jdk.jfr.DataAmount;
import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    String id;
    String name;
    String email;
    String password;
    String address;


}
