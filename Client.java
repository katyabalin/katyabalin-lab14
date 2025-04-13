import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    static final String key = "12345";
    private Socket SocketClient = null;
    private OutputStream out = null;

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

    public void handshake() {
        try {
            out = SocketClient.getOutputStream();
            PrintWriter pw = new PrintWriter(out);
            pw.write(key);
            pw.close();
        } catch (IOException e) {
            System.err.print("Output Stream error");
            e.printStackTrace();
        }
    }
}
