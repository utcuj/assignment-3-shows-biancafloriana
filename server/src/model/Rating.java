package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rating")
public class Rating implements Serializable {

    private static final long serialVersionUID = 6529685098267757698L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="id_user")
    private int userId;
    @Column(name ="id_show")
    private int showId;
    @Column
    private int rating;

    public Rating(int id, int userId, int showId, int rating) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.rating = rating;
    }

    public Rating(int userId, int showId, int rating) {
        this.userId = userId;
        this.showId = showId;
        this.rating = rating;
    }

    public Rating() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
