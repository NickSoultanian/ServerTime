
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* This class implements java socket client
* @author pankaj
*
*/
public class Client  {
public static void main(String[] args){
    try{
        Socket s = new Socket("localhost", 3500);//connect to ServerSocket
        InputStream is = s.getInputStream();  //generate InputStream from Socket
        byte[] b = new byte[2];
        is.read(b);  //read byte array into array b
        System.out.println("byte 1: " + b[0]); //print what was received
        System.out.println("byte 2: " + b[1]);
        is.close();  //close everything
        s.close();

    }catch(Exception e){
        System.out.println(e);
    }
}
}
