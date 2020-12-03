package Server;



import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerEchec {

    private int port = 2345;
    private String host = "192.168.1.132";
    private ServerSocket server = null;
    private boolean isRunning = true;

    public ServerEchec() {
        try {
            server = new ServerSocket(port, 3, InetAddress.getByName(host));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerEchec(String pHost, int pPort){
        host = pHost;
        port = pPort;
        try {
            server = new ServerSocket(port, 3, InetAddress.getByName(host));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void open(){

        Thread t = new Thread(new Runnable(){
            public void run(){

                while(isRunning){
                    try {
                        Socket client = server.accept();
                        System.out.println("Connexion cliente reçue.");

//                        Thread t = new Thread();
//                        t.start();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    server = null;
                }
            }
        });

        t.start();
    }

    public void close(){
        isRunning = false;
    }

}
