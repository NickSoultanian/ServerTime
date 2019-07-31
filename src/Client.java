import java.io.*;
import java.net.Socket;
/**
 *  Nicholas Soultanian
 *  Client.java
 *  Cs 3800
 *  Professor Young
 *  Client side of my server Project
*/
public class Client  {
    private final static String b1 = "C:\\Users\\Nicholas\\Desktop\\1B.txt";
    private final static String b500 = "C:\\Users\\Nicholas\\Desktop\\500B.txt";
    private final static String b10000 = "C:\\Users\\Nicholas\\Desktop\\10000B.txt";
    private final static String b80000 = "C:\\Users\\Nicholas\\Desktop\\80000B.txt";
    private final static String b400000 = "C:\\Users\\Nicholas\\Desktop\\400000B.txt";
    private final static String b2000000= "C:\\Users\\Nicholas\\Desktop\\2000000B.txt";

    private final static double rTT1B = .001069363;

    private final static double b1Size = 1;
    private final static double b500Size = 500;
    private final static double b10000Size = 10000;
    private final static double b80000Size = 80000;
    private final static double b400000Size = 400000;
    private final static double b2000000Size = 2000000;

    public static void main(String[] args){
    try{
        BufferedReader bufferedRead = new BufferedReader(new FileReader(b2000000));
        String placeHolder;
        StringBuilder file = new StringBuilder();
        while(( placeHolder = bufferedRead.readLine()) != null){
            file.append(placeHolder);
        }

        Socket server = new Socket("localhost", 5420);//connect to ServerSocket
        OutputStream outputStream = server.getOutputStream();


        outputStream.write(file.toString().getBytes());
        double start = System.nanoTime();

        PrintWriter printWriter = new PrintWriter(new FileWriter("Output1.txt"));
        InputStream inputStream = server.getInputStream();
        byte[] b = new byte[file.toString().length()];

        double end =System.nanoTime();
        double read = inputStream.read(b);


        double rTT = end-start;
        rTT = rTT * Math.pow(10,-9);
        System.out.println("Here is Round Trip Time: " + rTT);

        double throughPut = b2000000Size / rTT;
        System.out.println("Here is ThroughPut: " + throughPut);

        double effectiveBandwidth = ((b2000000Size * 8)/(rTT-rTT1B));
        System.out.println("Here is the Effective Bandwidth for a " + b2000000Size + "B file: " +effectiveBandwidth);
        outputStream.flush();
        outputStream.close();
        inputStream.close();  //close everything
        server.close();

    }catch(Exception e){
        System.out.println("RIP" + e);
        System.exit(0);
    }
}
}
