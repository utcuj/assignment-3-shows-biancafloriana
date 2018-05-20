package controller;

import model.BLL.ShowServices;
import model.Movie;
import model.Show;
import model.SportEvent;
import model.Theatre;
import view.AdminMovieView;
import view.AdminSportView;
import view.AdminTheatreView;
import view.IView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class ControllerAdminShow {

    private IView view;
    private String type;

    public ControllerAdminShow(String type) {

        this.type = type;
        switch (type) {

            case "movie":
                view = new AdminMovieView();
                break;
            case "sport":
                view = new AdminSportView();
                break;
            default:
                view = new AdminTheatreView();
        }

        listShow();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();


    }

    private void addListenerAddB() {

        ActionListener addButtonL = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    Object[] date = view.getShow();

                    if (!type.equals((String) date[3])) {

                        System.out.println("Not valide type!");
                    } else {
                        if (date[0] != null) {
                            Show m = null;

                            switch (type) {

                                case "movie":

                                    if (Integer.parseInt((String) date[5]) > 5 || Integer.parseInt((String) date[5]) < 0) {

                                        System.out.println("Not valid rating!");
                                    } else {
                                        m = new Movie();
                                        m.setId((int) date[0]);
                                        m.setName((String) date[1]);
                                        m.setDescription((String) date[2]);
                                        m.setType((String) date[3]);
                                        ((Movie) m).setActors((String) date[4]);
                                        ((Movie) m).setRating(Integer.parseInt((String) date[5]));
                                        m = ShowServices.update(m);
                                        view.updateRow(dateToVector(m));
                                    }
                                    break;
                                case "theatre":
                                    m = new Theatre();
                                    m.setId((int) date[0]);
                                    m.setName((String) date[1]);
                                    m.setDescription((String) date[2]);
                                    m.setType((String) date[3]);
                                    ((Theatre) m).setActors((String) date[4]);
                                    m = ShowServices.update(m);
                                    view.updateRow(dateToVector(m));
                                    break;
                                case "sport":
                                    m = new SportEvent();
                                    m.setId((int) date[0]);
                                    m.setName((String) date[1]);
                                    m.setDescription((String) date[2]);
                                    m.setType((String) date[3]);
                                    ((SportEvent) m).setTeam1((String) date[4]);
                                    ((SportEvent) m).setTeam2((String) date[5]);
                                    m = ShowServices.update(m);
                                    view.updateRow(dateToVector(m));
                                    break;

                            }


                        } else {
                            Show m = null;

                            switch (type) {
                                case "movie":
                                    if (Integer.parseInt((String) date[5]) > 5 || Integer.parseInt((String) date[5]) < 0) {

                                        System.out.println("Not valid rating!");
                                    } else {
                                        m = new Movie();
                                        // m.setId((int) date[0]);
                                        m.setName((String) date[1]);
                                        m.setDescription((String) date[2]);
                                        m.setType((String) date[3]);
                                        ((Movie) m).setActors((String) date[4]);
                                        ((Movie) m).setRating(Integer.parseInt((String) date[5]));
                                        m = ShowServices.insert(m);
                                        view.updateRow(dateToVector(m));

                                    }
                                    break;
                                case "theatre":
                                    m = new Theatre();
                                    // m.setId((int) date[0]);
                                    m.setName((String) date[1]);
                                    m.setDescription((String) date[2]);
                                    m.setType((String) date[3]);
                                    ((Theatre) m).setActors((String) date[4]);
                                    m = ShowServices.insert(m);
                                    view.updateRow(dateToVector(m));

                                    break;
                                case "sport":
                                    m = new SportEvent();
                                    //m.setId((int) date[0]);
                                    m.setName((String) date[1]);
                                    m.setDescription((String) date[2]);
                                    m.setType((String) date[3]);
                                    ((SportEvent) m).setTeam1((String) date[4]);
                                    ((SportEvent) m).setTeam2((String) date[5]);
                                    m = ShowServices.insert(m);
                                    view.updateRow(dateToVector(m));

                                    break;
                            }


                        }
                    }

                } catch (Exception e) {
                    view.printMessage("Datele nu sunt valide!");
                    e.printStackTrace();
                }
            }
        };
        view.addListenerAddB(addButtonL);
    }


    private Vector dateToVector(Show s) {

        Vector cols = new Vector();

        cols.add(s.getId());
        cols.add(s.getName());
        cols.add(s.getDescription());
        cols.add(s.getType());

        switch (type) {

            case "movie":
                cols.add(((Movie) s).getActors());
                cols.add(String.valueOf(((Movie) s).getRating()));
                break;
            case "theatre":
                cols.add(((Theatre) s).getActors());
                break;
            case "sport":
                cols.add(((SportEvent) s).getTeam1());
                cols.add(((SportEvent) s).getTeam2());
                break;
        }


        return cols;
    }

    private void addListenerNewB() {

        ActionListener ButtonL = arg0 -> {
            try {
                view.addNewRow();
            } catch (Exception e) {
                view.printMessage("Nu am putut adauga un rand nou in tabel!");
                //e.printStackTrace();
            }
        };

        view.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB() {

        ActionListener ButtonL = arg0 -> {
            try {
                Object[] date = view.getShow();
                if (date != null) {
                    ShowServices.delete((int) date[0]);
                    view.removeRow();
                }
            } catch (Exception e) {
                view.printMessage("Nu s-a putut face sterggerea!");

            }
        };
        view.addListenerDeleteB(ButtonL);
    }


    private void listShow() {

        List<Show> medList = ShowServices.findAll(type);

        for (Show med : medList) {
            Vector medV = dateToVector(med);
            view.addShow(medV);
        }
    }

}