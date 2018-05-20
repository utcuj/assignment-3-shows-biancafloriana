package model;


import java.io.Serializable;

public class Rating implements Serializable {

    private static final long serialVersionUID = 6529685098267757698L;
    private int id;

    private int userId;

    private int showId;

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
