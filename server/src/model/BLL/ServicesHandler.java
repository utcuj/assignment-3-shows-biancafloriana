package model.BLL;


import DAO.ActivityIDAO;
import DAO.CommentsIDAO;
import DAO.RatingIDAO;

import java.util.List;

public class ServicesHandler {
    public void execute(Request r) {

        String serviceName = r.getServiceName();

        switch (serviceName){

            case "user":
                new UserServices().execute(r);
                break;
            case "show":
                    new ShowServices().execute(r);
                  break;
            case "comment":
                    new AuxiliarServices( new CommentsIDAO()).execute(r);
                   break;
            case "rating":
                new AuxiliarServices( new RatingIDAO()).execute(r);
                break;
            case "activity":
                new AuxiliarServices( new ActivityIDAO()).execute(r);
                break;


        }

    }
    public void response(List list){
        Connection.getConnection().response(list);
    }
    public void response(Object o){
        Connection.getConnection().response(o);
    }
}
