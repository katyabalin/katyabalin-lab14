import java.io.*;
import java.net.Socket;

public class Client extends Thread {

    static final String key = "12345";
    private  Socket SocketClient = null;
    private OutputStream out =null;
    private InputStream in = null;
    public Client(String host, int port) {
        try{
            SocketClient = new Socket(host, port);
        }
        catch(Exception e) {
            System.err.print("Could not open client socket");
            e.printStackTrace();
        }

    }
    public Socket getSocket() {
        return SocketClient;
    }
    public void handshake() {
        try {
             out = SocketClient.getOutputStream();
             in = SocketClient.getInputStream();
             PrintWriter pw = new PrintWriter(out);
             pw.write(key);
             pw.close();
        }
        catch(IOException e) {
            System.err.print("Output Stream error");
            e.printStackTrace();
        }
    }
    public void disconnect() {
        try {
            SocketClient.close();
        }
        catch(IOException e) {
            System.err.print("Close socket error");
            e.printStackTrace();
        }
    }
    public String request(String numStr) {
        int num = 0;
        try {
            num = Integer.parseInt(numStr);
        }
        catch(NumberFormatException e) {
            return "There was an exception on the server";
        }
        if(num < 0) num = -num;

        int numFact = 1; //

        int num2 = num/2;
        for(int i = 2;i <= num2;i++ ) {
            if(num%i == 0) {
                numFact++;
            }
        }
        if(num > 1) numFact++;
        return "The number " + numStr +" has " + numFact +" factors";
    }
    public void run() {
        try {
            PrintWriter pw = new PrintWriter(out);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            while (true) {
                if (br.readLine() == null) break;
            }
            pw.close();
            br.close();
        }
        catch(Exception e) {
            System.err.print("Thread error run");
            e.printStackTrace();
        }

    }
}

