import java.io.*;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class Server {
    static final String key = "12345";
    private ServerSocket SocketServer = null;
    private ArrayList<LocalDateTime> times;

    public Server(int port) {
        try {
            SocketServer = new ServerSocket(port);
        } catch (Exception e) {
            System.err.print("couldn't open server socket");
            e.printStackTrace();
        }
        times = new ArrayList<LocalDateTime>();
    }
}

