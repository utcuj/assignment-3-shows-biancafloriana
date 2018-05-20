package model;

import java.io.Serializable;

public class Notification implements Serializable {

    private int id;
    private  int from;
    private int to;
    private int idShow;

    public Notification(int id, int from, int to, int idShow) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.idShow = idShow;
    }

    public Notification(int from, int to, int idShow) {
        this.from = from;
        this.to = to;
        this.idShow = idShow;
    }

    public int getIdShow() {
        return idShow;
    }

    public void setIdShow(int idShow) {
        this.idShow = idShow;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }
}
