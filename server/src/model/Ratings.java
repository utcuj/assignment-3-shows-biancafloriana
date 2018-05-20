package model;

import java.util.Map;

public class Ratings {

    private int movieId;
    private Map<User,Integer> userMap;

    public Ratings(int movieId, Map<User, Integer> userMap) {
        this.movieId = movieId;
        this.userMap = userMap;
    }

    public Map<User, Integer> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<User, Integer> userMap) {
        this.userMap = userMap;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }
}
