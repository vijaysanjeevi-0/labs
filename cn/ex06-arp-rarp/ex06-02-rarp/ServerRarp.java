import java.net.*;
import java.util.*;

public class ServerRarp {
    public static void main(String[] a) throws Exception {
        Map<String, String> t = Map.of("6A:08:AA:C2", "165.165.80.80", "8A:BC:E3:FA", "165.165.79.1");
        DatagramSocket s = new DatagramSocket(1309);
        while (true) {
            DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
            s.receive(p);
            byte[] r = t.getOrDefault(new String(p.getData(), 0, p.getLength()), "Not found").getBytes();
            s.send(new DatagramPacket(r, r.length, p.getAddress(), p.getPort()));
        }
    }
}
