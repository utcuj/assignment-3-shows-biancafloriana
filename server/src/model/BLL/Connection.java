package model.BLL;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Connection {
    
    private static Connection connection;
    private static ServerSocket myService;
    private  Socket clientSocket = null;
    private  static ObjectInputStream serverInputStream;
    private  static ObjectOutputStream serverOutputStream;
    private  Connection(){}

    public static Connection getConnection() {

        if(myService == null){
            try {
                connection = new Connection();
                connection.myService  = new ServerSocket( 1234);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }else {

            return connection;
        }
    }

    public void waitForRequest(){
        System.out.println("waiting");
        try {
            connection.clientSocket = myService.accept();
            serverInputStream =  new
                    ObjectInputStream(clientSocket.getInputStream());

            Request r = (Request) serverInputStream.readObject();
            System.out.println(r.getType());
            System.out.println("execute " + r.getType() + " " + r.getServiceName());
            new ServicesHandler().execute(r);
           // serverInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("got request");

    }
    
    public void response(Object o){
        System.out.println("response object");
        try {
            serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            serverOutputStream.writeObject(o);
            serverOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void response(List list){
        System.out.println("response list");
        try {
            serverOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            serverOutputStream.writeObject(list);
            //serverOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    
}
