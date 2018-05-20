package model;


import java.io.Serializable;


public class Activity implements Serializable {

    private static final long serialVersionUID = 6529685098267757659L;

    private int id;

    private int userId;

    private int showId;

    public Activity(int id, int userId, int showId) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
    }

    public Activity(int userId, int showId) {
        this.userId = userId;
        this.showId = showId;
    }

    public Activity() {
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
}
