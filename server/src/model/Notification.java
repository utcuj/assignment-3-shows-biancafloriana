package model;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private  int from;
    @Column
    private int to;
    @Column
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
