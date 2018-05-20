package model;


import java.io.Serializable;

public class Movie extends  Show implements Serializable {

    private static final long serialVersionUID = 6529685098267757693L;
    private String actors;


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
