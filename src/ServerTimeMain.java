import java.net.ServerSocket;
import java.net.Socket;

public class ServerTimeMain {
    public static void main(String args[]){
        try {
            ServerSocket ss = new ServerSocket(3600);
            Socket s = ss.accept();
            Socket simplesocket = new Socket("192.168.0.8", 3600);
            System.out.println("it worked");
        }catch(Exception e){
            System.out.println("Rip");
            System.exit(0);

        }
        System.out.println("Hello Java");
    }
}
