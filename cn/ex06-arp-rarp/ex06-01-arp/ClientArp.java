import java.io.*;
import java.net.*;
import java.util.*;

public class ClientArp {
    public static void main(String[] a) throws Exception {
        System.out.println("Enter the Logical address(IP):");
        Socket s = new Socket("localhost", 9139);
        new PrintWriter(s.getOutputStream(), true).println(new Scanner(System.in).nextLine());
        System.out.println("The Physical Address is: " + new Scanner(s.getInputStream()).nextLine());
    }
}
