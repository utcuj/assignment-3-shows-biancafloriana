package controller;

import model.BLL.ShowServices;
import model.BLL.UserServices;
import model.PremiumUser;
import model.Show;
import model.User;
import view.PremiumUserView;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class PremiumUserController {

    private PremiumUserView premiumUserView;
    private int idUser;
    private PremiumUser premiumUser;

    PremiumUserController(User user) {
        this.premiumUser =(PremiumUser) user;
        idUser = premiumUser.getId();
        premiumUserView = new PremiumUserView();
        listShow();
        addListenerSearch();
        addListenerDetails();
        addListenerHistory();
        addListenerInterested();
        addListenerNotify();
        listNotifications();

    }

    private void addListenerSearch() {

        ActionListener addButtonL = arg0 -> {

            String date = premiumUserView.getText();


            Show m = ShowServices.findByName(date);
            premiumUserView.clear();
            if(m!= null) {
                premiumUserView.addShow(dateToVector(m));
            }

        };
        premiumUserView.addListenerSearch(addButtonL);
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
            premiumUserView.addShow(showV);
            //System.out.println("done");
        }
    }


    private void listShow() {

        List<Show> showList = ShowServices.findAll();

        for (Show show : showList) {
            Vector showV = dateToVector(show);

            premiumUserView.addShow(showV);
        }
    }

    private void addListenerDetails() {

        ActionListener addButtonL = arg0 -> {

            Object[] date = premiumUserView.getShow();

            new ControllerDetails((String)date[3],(int)date[0],idUser);

        };
        premiumUserView.addListenerDetails(addButtonL);
    }

    private void addListenerHistory() {

        ActionListener addButtonL = arg0 -> {

            new ControllerHistory(idUser);

        };
        premiumUserView.addListenerHistory(addButtonL);
    }

    private void listNotifications() {

        List showList = premiumUser.getNotifications();

        for (Object s : showList) {

            premiumUserView.addNotify((String) s);
        }
    }
    private void addListenerInterested() {

        ActionListener addButtonL = arg0 -> {

            Object[] t = premiumUserView.getShow();
            premiumUser.addInterested((int)t[0]);
            UserServices.addInterested(premiumUser);

        };
        premiumUserView.addListenerIntresed(addButtonL);
    }

    private void addListenerNotify() {

        ActionListener addButtonL = arg0 -> {

            Object[] t = premiumUserView.getShow();
            int user = Integer.valueOf(premiumUserView.getUser());
            UserServices.recommend(premiumUser.getId(),user,(int)t[0]);

        };
        premiumUserView.addListenerIntresed(addButtonL);
    }
}
