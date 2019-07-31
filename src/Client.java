
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
    private final static String b10000 = "C:\\Users\\Nicholas\\Desktop\\10000B.txt";
    private final static String b80000 = "C:\\Users\\Nicholas\\Desktop\\80000B.txt";
    private final static String b400000 = "C:\\Users\\Nicholas\\Desktop\\400000B.txt";
    private final static String b2000000= "C:\\Users\\Nicholas\\Desktop\\2000000B.txt";

    private final static double rTT1B = 1;

    private final static double b1Size = 1;
    private final static double b500Size = 500;
    private final static double b10000Size = 10000;
    private final static double b80000Size = 80000;
    private final static double b400000Size = 400000;
    private final static double b2000000Size = 2000000;

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

        double rTT = end-start;
        System.out.println("Here is Round Trip Time: " + rTT);

        double throughPut = b1Size / rTT;
        System.out.println("Here is ThroughPut: " + throughPut);

        double effectiveBandwidth = (b1Size/(rTT-rTT1B));
        System.out.println("Here is the Effective Bandwidth for a" + b1Size + "B file: ");


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
