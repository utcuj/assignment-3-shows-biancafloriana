package controller;

import model.BasicUser;
import model.User;
import model.BLL.UserServices;
import view.BasicUserView;
import view.DetailsView;
import view.LoginView;
import view.PremiumUserView;

import java.awt.event.ActionListener;

public class LoginController {

    private LoginView loginView;
    private UserServices userServices;

    private LoginController() {
        loginView = new LoginView();
        userServices = new UserServices();
        addListener();
    }

    private void addListener() {

        ActionListener ButtonL = arg0 -> {
                Object[] date = loginView.getInfo();
                User user = new User((String) date[0], (String) date[1]);
                if(userServices.logIn(user)){
                    new ControllerBuilder().getController(userServices.getUser());

                   System.out.println("ok");
                }else{

                    System.out.println("not ok");
                }

        };
        loginView.addListener(ButtonL);
    }

    public static void main(String[] args) {

        new LoginController();
        //new PremiumUserView();
    }

}
