import java.net.ServerSocket;
import java.net.Socket;
import java.lang.*;
import java.io.*;

public class ServerTimeMain {
    private static ServerSocket server;
    public static void main(String args[]){
                try{

                    ServerSocket ss = new ServerSocket(3500);//declare a new ServerSocket on port 3500
                    Socket s = ss.accept( );  //open the ServerSocket to receive connections
                    OutputStream os = s.getOutputStream( );  //generate an outputstream from the Socket
                    byte[] b = new byte[2];
                    b[0] = 1;
                    b[1] = 2;
                    os.write(b);  //write the array
                    os.close();   //close everything
                    s.close( );
                    ss.close( );

                }catch(Exception e){
                    System.out.println(e);
                }
            }


        }


// Socket simplesocket = new Socket("192.168.0.8", 3600);
//                System.out.println("it worked");
//import java.net.*;
//import java.io.*;
//class server{
//    public static void main(String[] args){
//        try{
//
//            ServerSocket ss = new ServerSocket(3500);//declare a new ServerSocket on port 3500
//            Socket s = ss.accept( );  //open the ServerSocket to receive connections
//            OutputStream os = s.getOutputStream( );  //generate an outputstream from the Socket
//            byte[] b = new byte[2];
//            b[0] = 1;
//            b[1] = 2;
//            os.write(b);  //write the array
//            os.close();   //close everything
//            s.close( );
//            ss.close( );
//
//        }catch(Exception e){
//             System.out.println(e);
//         }
//   }
//
//
//}