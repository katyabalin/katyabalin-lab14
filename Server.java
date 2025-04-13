import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Server {
    static final String key = "12345";
    private ServerSocket SocketServer = null;
    private ArrayList<LocalDateTime> times;
    public Server(int port) {
        try {
            SocketServer = new ServerSocket(port);
        }
        catch(Exception e) {
            System.err.print("Could not open server socket");
            e.printStackTrace();
        }
        times = new ArrayList<LocalDateTime>();
    }
    public void serve(int Num) {
       for(int i = 0;i <Num;i++) {
           try{
               Socket clientSock = SocketServer.accept();
               BufferedReader in = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
               String fromClient = in.readLine();
               //in.close();
               if(fromClient.equals(key)) {
                  // clientSock.start();
                   times.add(LocalDateTime.now());
               } else {
                   PrintWriter pw = new PrintWriter(clientSock.getOutputStream());
                   pw.write("couldn't handshake");
                   pw.close();
               }


           }
           catch(Exception e) {
               e.printStackTrace();
           }
       }
    }
    public void disconnect() {
        try {
            SocketServer.close();
        }
        catch(IOException e) {
            System.err.print("Close server socket error");
            e.printStackTrace();
        }
    }
    public ArrayList<LocalDateTime> getConnectedTimes() {
        return times;
    }
}

