import java.net.ServerSocket;
import java.net.Socket;
import java.lang.*;
import java.io.*;

public class ServerTimeMain {
    private static ServerSocket server;
    public static void main(String args[]) throws IOException{
                try{
                    server = new ServerSocket(5420);

                    byte[] data = new byte[2000000]; // since our biggest file is 2x 10^6 byte
                    Socket s = server.accept();
                    InputStream in = s.getInputStream();
                    in.read(data);


                    OutputStream os = s.getOutputStream();
                    os.write(data);
                    System.out.println("data " + data);
                    System.out.println("data length" + data.length);
                    os.flush();
                    os.close();
                    in.close();
                    s.close();
                    server.close();
                    
                }catch(Exception e){
                    System.out.println("RIP");
                    System.exit(0);
                }


        }

}