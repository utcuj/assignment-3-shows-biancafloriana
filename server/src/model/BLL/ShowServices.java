package model.BLL;

import DAO.ShowDAO;
import model.Show;

import java.util.List;

public class ShowServices {
    public void execute(Request r) {
        String type = r.getType();
        switch (type){

            case "read":
                this.read();
                break;
            case "findById":
                this.findById(r.getData());
                break;
            case "findByTitle":
                this.findByTitle(r.getData());
                break;
            case "insert":
                this.create(r.getData());
                break;
            case "update":
                this.update(r.getData());
                break;
            case "delete":
                this.delete(r.getData());
                break;
            case "readMovie":
                this.readMovie();
                break;
            case "readTheatre":
                this.readTheatre();
                break;
            case "readSport":
                this.readSport();
                break;

        }
    }

    private void delete(Object data) {
        new ShowDAO().delete((Show)data);

    }

    private void update(Object data) {
       new ShowDAO().update((Show)data);
        new ServicesHandler().response(data);

    }

    private void create(Object data) {
       new ShowDAO().create((Show)data);
        new ServicesHandler().response(data);

    }

    private void findByTitle(Object data) {

        Show s = new ShowDAO().findByTitle((Show)data);
        new ServicesHandler().response(s);

    }

    private void findById(Object data) {

        Show s = new ShowDAO().findByID((Show)data);
        new ServicesHandler().response(s);
    }


    private void readSport() {
        List list = new ShowDAO().readSportEvent();
        new ServicesHandler().response(list);
    }

    private void readTheatre() {
        List list = new ShowDAO().readTheatre();
        new ServicesHandler().response(list);
    }

    private void readMovie() {
        List list = new ShowDAO().readMovies();
        new ServicesHandler().response(list);
    }
    private void read(){

        List list = new ShowDAO().read();
        new ServicesHandler().response(list);

    }
}
