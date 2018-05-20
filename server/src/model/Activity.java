package model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name ="history")
public class Activity implements Serializable {

    private static final long serialVersionUID = 6529685098267757659L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name ="id_user")
    private int userId;
    @Column(name ="id_show")
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
