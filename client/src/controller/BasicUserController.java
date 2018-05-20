package controller;

import model.BLL.ShowServices;
import model.Show;
import view.BasicUserView;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class BasicUserController {

    private BasicUserView basicUserView;
    private int idUser;

    BasicUserController(int idUser) {
        this.idUser = idUser;
        basicUserView = new BasicUserView();
        listShow();
        addListenerSearch();
        addListenerDetails();
        addListenerHistory();
        //addListenerDeleteB();


    }

    private void addListenerSearch() {

        ActionListener addButtonL = arg0 -> {

            String date = basicUserView.getText();


            Show m = ShowServices.findByName(date);
            basicUserView.clear();
            if(m!= null) {
                basicUserView.addShow(dateToVector(m));
            }

        };
        basicUserView.addListenerSearch(addButtonL);
    }

    private Vector dateToVector(Show show) {

        Vector ShowV = new Vector();

        ShowV.add(show.getId());
        ShowV.add(show.getName());
        ShowV.add(show.getDescription());
        ShowV.add(show.getType());

        return ShowV;
    }

    private void addToView(List<Show> m) {
        for (Show show : m) {

            Vector showV = dateToVector(show);
            basicUserView.addShow(showV);
            //System.out.println("done");
        }
    }


    private void listShow() {

        List<Show> showList = ShowServices.findAll();

        for (Show show : showList) {
            Vector showV = dateToVector(show);

            basicUserView.addShow(showV);
        }
    }

    private void addListenerDetails() {

        ActionListener addButtonL = arg0 -> {

            Object[] date = basicUserView.getShow();

            new ControllerDetails((String)date[3],(int)date[0],idUser);

        };
        basicUserView.addListenerDetails(addButtonL);
    }

    private void addListenerHistory() {

        ActionListener addButtonL = arg0 -> {

            new ControllerHistory(idUser);

        };
        basicUserView.addListenerHistory(addButtonL);
    }
}
