package model.BLL;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerConnection {

    private static ServerConnection serverConnection;
    private static Socket myClient;

    private ServerConnection(){

    }

    public static ServerConnection getConnection() {

        if(myClient == null){

                serverConnection = new ServerConnection();


            return serverConnection;
        }else {

            return serverConnection;
        }
    }

    public void makeReguest(Request r){
        System.out.println("Making request "  + r.getType() + " " + r.getServiceName());
        try {
            serverConnection.myClient  = new Socket("127.0.0.1", 1234);
            ObjectOutputStream clientOutputStream = new
                    ObjectOutputStream(myClient.getOutputStream());
            clientOutputStream.writeObject(r);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object getResponse(){
        System.out.println("get response obj");
        ObjectInputStream clientInputStream = null;
        Object o = null;
        try {
            clientInputStream = new
                    ObjectInputStream(myClient.getInputStream());
           o = clientInputStream.readObject();
           clientInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("got response obj");
        return o;
    }

    public List getResponseList(){
        System.out.println("get response list");
        ObjectInputStream clientInputStream = null;
        List list = null;
        try {
            clientInputStream = new
                    ObjectInputStream(myClient.getInputStream());
            list = (ArrayList) clientInputStream.readObject();
            clientInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("got response list");
        return list;
    }

}
