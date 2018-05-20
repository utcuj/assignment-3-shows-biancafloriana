package controller;

import model.User;
import view.AdminChooseView;
import view.AdminShowChooseView;

import java.awt.event.ActionListener;

public class AdminChooseController {


    private AdminChooseView adminChooseView = new AdminChooseView();

    AdminChooseController() {

        addListenerMedication();
        addListenerEmployee();

    }

    private void addListenerEmployee() {
        ActionListener addButtonL = arg0 -> {
            new AdminEmployeeController();
            adminChooseView.dispose();

        };

        adminChooseView.addListenerEmployeeB(addButtonL);
    }

    private void addListenerMedication() {

        ActionListener addButtonL = arg0 -> {
            new ControllerAdminChooseShow();
            adminChooseView.dispose();

        };

        adminChooseView.addListenerShowB(addButtonL);

    }
}
