package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="movie")
@PrimaryKeyJoinColumn(name="id")
public class Movie extends  Show implements Serializable {

    private static final long serialVersionUID = 6529685098267757693L;
    @Column
    private String actors;

    @Column
    private int rating;

    public Movie(String name, String description, String actors, int rating,String type,String available) {
        super(name, description, type, available);
        this.actors = actors;
        this.rating = rating;
    }

    public Movie(int id, String name, String description, String actors, int rating,String type,String available) {
        super(id, name, description, type, available);
        this.actors = actors;
        this.rating = rating;
    }

    public Movie() {
        super();
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
