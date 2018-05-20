import model.BLL.Connection;

public class App {
    public  static void main(String[] arg){


    /*    ServerSocket MyService= null;
        Socket clientSocket = null;
        try {
            MyService = new ServerSocket(1234);
            clientSocket = MyService.accept();
        }
        catch (IOException e) {
            System.out.println(e);
        }*/


        while(true){
            Connection connection = Connection.getConnection();
        connection.waitForRequest();
    }}
}
