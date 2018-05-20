package controller;

import model.BLL.UserServices;
import model.User;
import view.AdminEmployeeView;


import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AdminEmployeeController {

    private AdminEmployeeView adminEmployeeView;

    AdminEmployeeController() {
        adminEmployeeView = new AdminEmployeeView();
        listEmployee();
        addListenerAddB();
        addListenerNewB();
        addListenerDeleteB();


    }

    private void addListenerAddB() {

        ActionListener addButtonL = arg0 -> {

                Object[] date = adminEmployeeView.getUser();
            System.out.println("add");


                        User u = new User();
                    try {
                        u.setUsername((String) date[1]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    u=  new UserServices().findByUsername(u);
                        if(u != null){
                          new  UserServices().update(new User((int) date[0],(String) date[1], (String) date[2],(String)date[3]));
                        }


                        if ((int) date[5] >= (int) date[4]) {
                            new UserServices().insert(new User((String) date[1], (String) date[2],(String)date[3]));


                    // System.out.println(date[3] + " " + date[2]);

                }
                //adminEmployeeView.printMessage("Datele nu sunt valide!");
                //e.printStackTrace();
        };

        adminEmployeeView.addListenerAddB(addButtonL);
    }


    private void addListenerNewB() {

        ActionListener ButtonL = arg0 -> {

                adminEmployeeView.addNewRow();

        };

        adminEmployeeView.addListenerNewRB(ButtonL);
    }

    private void addListenerDeleteB() {

        ActionListener ButtonL = arg0 -> {

                Object[] date = adminEmployeeView.getUser();

                if (date != null) {
                   new UserServices().delete((int) date[0]);
                    adminEmployeeView.removeRow();
                }

        };
        adminEmployeeView.addListenerDeleteB(ButtonL);
    }


    private void listEmployee() {

        List<User> userList =new  UserServices().findAllUsers();

        for (User user : userList) {
            Vector userV = new Vector();

            userV.add(user.getId());
            userV.add(user.getUsername());
            userV.add(user.getPassword());
            userV.add(user.getType());

            adminEmployeeView.addUser(userV);
        }
    }


}


