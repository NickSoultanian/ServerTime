
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
    private final static String b1 = "C:\\Users\\Nicholas\\Desktop\\1B.txt";
    private final static String b500 = "C:\\Users\\Nicholas\\Desktop\\500B.txt";

    private final static String b100000 = "C:\\Users\\Nicholas\\Desktop\\10000B.txt";
    private final static String b800000 = "C:\\Users\\Nicholas\\Desktop\\80000B.txt";


    public static void main(String[] args){
    try{
        BufferedReader br = new BufferedReader(new FileReader(b1));
        String temp;
        StringBuilder file = new StringBuilder();
        while(( temp = br.readLine()) != null){
            file.append(temp);
        }

        Socket server = new Socket("localhost", 5420);//connect to ServerSocket
        OutputStream os = server.getOutputStream();

        os.write(file.toString().getBytes());
        double start = System.nanoTime();
        os.flush();

        PrintWriter pw = new PrintWriter(new FileWriter("Output1.txt"));
        InputStream is = server.getInputStream();
        byte[] b = new byte[file.toString().length()];
        double end =System.nanoTime();
        is.read(b);

        double elapse = end-start;
        System.out.println(elapse);

        for(byte a : b )
            pw.print(Character.toChars(a));

        os.close();
        is.close();  //close everything
        server.close();

    }catch(Exception e){
        System.out.println("RIP");
        System.exit(0);
    }
}
}
