package model;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 6529685098267757690L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String type;

    public User() {
    }

    public User(int id, String username, String password, String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public User(String username, String password, String type) {
        this.username = username;
        this.password = password;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws Exception {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {
        this.password = password;
    }


    public String toString() {
        return this.username;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}