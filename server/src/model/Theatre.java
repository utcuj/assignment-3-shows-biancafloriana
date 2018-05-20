package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="theatre")
@PrimaryKeyJoinColumn(name="id")
public class Theatre extends Show implements Serializable {

    private static final long serialVersionUID = 6529685098267757692L;
    @Column
    private String actors;


    public Theatre(String name, String description, String actors,String type,String available) {
        super(name, description, type, available);
        this.actors = actors;
    }

    public Theatre(int id, String name, String description, String actors,String type,String available) {
        super(id, name, description, type, available);
        this.actors = actors;
    }

    public Theatre() {

    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
