import java.net.ServerSocket;
import java.net.Socket;
import java.lang.*;
import java.io.*;
/**
 *  Nicholas Soultanian
 *  ServerTime.java.java
 *  Cs 3800
 *  Professor Young
 *  Server side of my server Project
 */
public class ServerTimeMain {
    private static ServerSocket server;
    public static void main(String args[]) throws IOException{
                try{
                    server = new ServerSocket(5420);

                    byte[] data = new byte[2000000];
                    Socket socket = server.accept();
                    InputStream inputStream = socket.getInputStream();
                    inputStream.read(data);
                    OutputStream ouputStream = socket.getOutputStream();
                    ouputStream.write(data);
                    System.out.println("Here is the Data Going in" + data);
                    Thread.sleep(10000);
                    ouputStream.flush();
                    ouputStream.close();
                    inputStream.close();
                    socket.close();
                    server.close();
                }catch(Exception e){
                    System.out.println("RIP");
                    System.exit(0);
                }


        }

}