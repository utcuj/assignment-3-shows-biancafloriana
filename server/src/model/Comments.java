package model;

import java.util.Map;

public class Comments {

    private int showId;
    private Map<User,String> userMap;


    public int getshowId() {
        return showId;
    }

    public void setshowId(int showId) {
        this.showId = showId;
    }

    public Map<User, String> getUserMap() {
        return userMap;
    }

    public void setUserMap(Map<User, String> userMap) {
        this.userMap = userMap;
    }
}
