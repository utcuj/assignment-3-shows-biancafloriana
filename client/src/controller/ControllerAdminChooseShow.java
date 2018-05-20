package controller;

import model.User;
import view.AdminChooseView;
import view.AdminShowChooseView;

import java.awt.event.ActionListener;

public class ControllerAdminChooseShow {


    private AdminShowChooseView adminChooseView = new AdminShowChooseView();

    ControllerAdminChooseShow() {

        addListenerMedication();
        addListenerEmployee();
        addListenerTheatre();
    }

    private void addListenerEmployee() {
        ActionListener addButtonL = arg0 -> {
            new ControllerAdminShow("theatre");
            adminChooseView.dispose();

        };

        adminChooseView.addListenerTheatreB(addButtonL);
    }

    private void addListenerTheatre() {
        ActionListener addButtonL = arg0 -> {
            new ControllerAdminShow("sport");
            adminChooseView.dispose();

        };

        adminChooseView.addListenerSportB(addButtonL);
    }

    private void addListenerMedication() {

        ActionListener addButtonL = arg0 -> {
            new ControllerAdminShow("movie");
            adminChooseView.dispose();

        };

        adminChooseView.addListenerMovieB(addButtonL);

    }
}
