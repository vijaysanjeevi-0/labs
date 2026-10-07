import java.io.*;
import java.net.*;
import java.util.*;

public class ServerArp {
    public static void main(String[] a) throws Exception {
        Map<String, String> t = Map.of("165.165.80.80", "6A:08:AA:C2", "165.165.79.1", "8A:BC:E3:FA");
        ServerSocket ss = new ServerSocket(9139);
        while (true) {
            Socket c = ss.accept();
            String ip = new Scanner(c.getInputStream()).nextLine();
            new PrintWriter(c.getOutputStream(), true).println(t.getOrDefault(ip, "Not found"));
            c.close();
        }
    }
}
