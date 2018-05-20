package controller;

import model.Activity;
import model.BLL.UserServices;
import view.HistoryView;

import java.util.List;
import java.util.Vector;

public class ControllerHistory {

    private HistoryView historyView;
    private int idUser;
    public ControllerHistory(int idUser) {
        historyView = new HistoryView();
        this.idUser = idUser;
        
        listHistory();
    }

    private Vector dateToVector(Activity activity) {

        Vector activityV = new Vector();

        activityV.add(activity.getShowId());

        return activityV;
    }


    private void listHistory() {

        List<Activity> ActivityList = UserServices.findAll(idUser);
        System.out.println(ActivityList.size());

        for (Activity Activity : ActivityList) {
            Vector ActivityV = dateToVector(Activity);

            historyView.addActivity(ActivityV);
        }
    }

}
