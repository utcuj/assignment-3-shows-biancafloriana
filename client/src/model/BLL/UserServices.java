package model.BLL;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class UserServices {

        private User user;

    public static boolean addActivity(int idUser, int id) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        // User u = new User("admin","nunu");
        Activity a= new Activity(idUser,id);
       // System.out.println(a.getShowId() + " "+ a.getUserId());
        Request r = new Request("create","activity",a);
        serverConnection.makeReguest(r);
        //Boolean ok  = (Boolean) serverConnection.getResponse();
        // System.out.println(u.getType());

        return true;
    }



    public static void recommend(int id, int user, int i) {

        ServerConnection serverConnection = ServerConnection.getConnection();
        Notification n = new Notification(id, id,user,i);
        Request r = new Request("create","userPremium",n);
        serverConnection.makeReguest(r);
        //user = (User)serverConnection.getRespo


    }

    public static void addInterested(PremiumUser premiumUser) {

        ServerConnection serverConnection = ServerConnection.getConnection();
        // User u = new User("admin","nunu");
        Request r = new Request("update","userPremium",premiumUser);
        serverConnection.makeReguest(r);
        //user = (User)serverConnection.getResponse();
        // System.out.println(u.getType());

      //  return user;
    }

    public  void delete(int s) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        User u = new User();
        try {
            u.setId(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Request r = new Request("delete","user",u);
        serverConnection.makeReguest(r);
        //   user = (User)serverConnection.getResponse();
        // System.out.println(u.getType());

        //return user;
    }


    public  User update(User user) {
        ServerConnection serverConnection = ServerConnection.getConnection();
        // User u = new User("admin","nunu");
        Request r = new Request("update","user",user);
        serverConnection.makeReguest(r);
        //user = (User)serverConnection.getResponse();
        // System.out.println(u.getType());

        return user;
    }

    public  User insert(User user) {

        ServerConnection serverConnection = ServerConnection.getConnection();
        // User u = new User("admin","nunu");
        Request r = new Request("insert","user",user);
        serverConnection.makeReguest(r);
        //user = (User)serverConnection.getResponse();
        // System.out.println(u.getType());

        return user;
    }

    public User findByUsername(User user) {

                ServerConnection serverConnection = ServerConnection.getConnection();
               // User u = new User("admin","nunu");
                Request r = new Request("findByUsername","user",user);
                serverConnection.makeReguest(r);
                user = (User)serverConnection.getResponse();
               // System.out.println(u.getType());

                return user;
        }

        public boolean logIn(User user) {

                User dbUser = findByUsername(user);

                if(dbUser != null){

                     this.user = dbUser;
                        System.out.println(dbUser.getPassword());
                    return dbUser.getPassword().equals(user.getPassword());

                }


                return false;
        }

        public User getUser() {
                return user;
        }
        public User getSpecializedUser(User u) {

                String type = u.getType();

                switch (type) {

                        case "basic":
                                return new BasicUser(user);
                        case "premium":
                            //TO DO
                            return user;
                         default:
                                return user;
                }

        }

    public static List<Activity> findAll(int idUser) {

        ServerConnection serverConnection = ServerConnection.getConnection();

        Request r = new Request("read","activity",idUser);
        serverConnection.makeReguest(r);
        List<Activity> list= (ArrayList)serverConnection.getResponseList();
        return list;

    }

    public List<User> findAllUsers() {

        ServerConnection serverConnection = ServerConnection.getConnection();

        Request r = new Request("read","user",null);
        serverConnection.makeReguest(r);
        List<User> list= (ArrayList)serverConnection.getResponseList();
        return list;
    }
}
