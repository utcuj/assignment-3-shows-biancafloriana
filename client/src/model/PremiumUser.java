package model;

import java.util.List;

public class PremiumUser extends User {

    private List interested;
    private List notifications;

    public PremiumUser(List interested, List notifications) {
        this.interested = interested;
        this.notifications = notifications;
    }

    public List getNotifications() {
        return notifications;
    }

    public void setNotifications(List notifications) {
        this.notifications = notifications;
    }

    public List getInterested() {
        return interested;
    }

    public void setInterested(List interested) {
        this.interested = interested;
    }

    public void addInterested(int i) {
        interested.add(i);
    }
}
