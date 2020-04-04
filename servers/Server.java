package servers;

import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;

public class Server {
    public static Connection connection;
    public static void main(String[] args) {
        try{
            connectToDb();
            ServerSocket ss = new ServerSocket(3999);

            while(true){
                System.out.println("waiting for client");
                Socket socket = ss.accept();
                System.out.println("new client connected");

                ServerThread sth = new ServerThread(socket,connection);
                sth.start();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static  void connectToDb(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/imovie?serverTimezone=UTC",
                            "root",
                            "010809500518ana");
            System.out.println("Connected to DB");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
