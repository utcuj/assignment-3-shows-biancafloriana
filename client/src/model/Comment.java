package model;


import java.io.Serializable;

public class Comment implements Serializable {
    private static final long serialVersionUID = 6529685098267757699L;
    private  int id;

    private  int userId;

    private  int showId;


    private  String text;

    public Comment(int id ,int userId, int showId, String text) {
        this.id = id;
        this.userId = userId;
        this.showId = showId;
        this.text = text;
    }

    public Comment(int userId, int showId, String text) {
        this.userId = userId;
        this.showId = showId;
        this.text = text;
    }

    public Comment() {
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
