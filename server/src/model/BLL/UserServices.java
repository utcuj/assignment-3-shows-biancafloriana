package model.BLL;

import DAO.UserDAO;
import model.User;

import java.util.List;

public class UserServices {
    public void execute(Request r) {

        String type = r.getType();
        switch (type){

            case "findByUsername":
                    this.findByUsername((User) r.getData());
                    break;
            case "read":
                this.read();
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

        }
    }


    private void update(Object data) {
        new UserDAO().update((User)data);

    }

    private void delete(Object data) {
        new UserDAO().delete((User)data);

    }

    private void create(Object data) {

        new UserDAO().create((User)data);

    }

    private void read() {
        List list = new UserDAO().read();
        new ServicesHandler().response(list);
    }

    private void findByUsername(User data) {

        data = new UserDAO().findByUsername(data.getUsername());
        new ServicesHandler().response(data);
    }
}
