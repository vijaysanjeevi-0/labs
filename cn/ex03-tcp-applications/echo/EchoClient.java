import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] a) throws Exception {
        Scanner kb = new Scanner(System.in);
        Socket s = new Socket("localhost", 9000);
        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String line;
        System.out.print("Client: ");
        while (!(line = kb.nextLine()).equals("end")) {
            out.println(line);
            System.out.println("Server: " + in.nextLine());
            System.out.print("Client: ");
        }
    }
}
