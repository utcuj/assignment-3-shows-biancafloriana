package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="event")
@Inheritance(strategy = InheritanceType.JOINED)
public class Show implements Serializable {

    private static final long serialVersionUID = 6529685098267757691L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private  String type;

    @Column
    private String available;

    public Show(String name, String description, String type, String available) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.available = available;
    }

    public Show(int id, String name, String description, String type, String available) {
        this(name,description, type, available);
        this.id = id;

    }

    public Show() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }
}
