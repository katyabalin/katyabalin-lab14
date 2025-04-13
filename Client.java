import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    static final String key = "12345";
    private Socket SocketClient = null;

    public Client(String host, int port) {
        try {
            SocketClient = new Socket(host, port);
        } catch (Exception e) {
            System.err.print("couldn't open client socket");
            e.printStackTrace();
        }
    }

    public Socket getSocket() {
        return SocketClient;
    }
}

