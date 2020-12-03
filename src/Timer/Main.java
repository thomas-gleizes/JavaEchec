package Timer;
public class Main {

    public static void main(String[] args) {

        String host = "192.168.1.132";
        int port = 2345;

        TimeServer ts = new TimeServer(host, port);
        ts.open();

        System.out.println("Serveur initialisé.");

        for(int i = 0; i < 1; i++){
            Thread t = new Thread(new ClientConnexion(host, port));
            t.start();
        }
    }
}