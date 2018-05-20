package model;


import java.io.Serializable;

public class SportEvent extends Show implements Serializable {

    private static final long serialVersionUID = 6529685098267757694L;

    private String team1;


    private String team2;

    public SportEvent(String name, String description, String team1, String team2,String type,String available) {
        super(name, description, type, available);
        this.team1 = team1;
        this.team2 = team2;
    }

    public SportEvent(int id, String name, String description, String team1, String team2,String type,String available) {
        super(id, name, description, type, available);
        this.team1 = team1;
        this.team2 = team2;
    }

    public SportEvent() {

    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }
}
