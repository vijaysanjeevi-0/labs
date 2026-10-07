import java.net.*;
import java.util.*;

public class UdpDnsServer {
    public static void main(String[] a) throws Exception {
        Map<String, String> table = Map.of(
            "yahoo.com", "68.180.206.184",
            "gmail.com", "209.85.148.19",
            "cricinfo.com", "80.168.92.140",
            "facebook.com", "69.63.189.16");
        DatagramSocket s = new DatagramSocket(1362);
        while (true) {
            DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
            s.receive(p);
            String host = new String(p.getData(), 0, p.getLength());
            System.out.println("Request for host " + host);
            byte[] r = table.getOrDefault(host, "Host Not Found").getBytes();
            s.send(new DatagramPacket(r, r.length, p.getAddress(), p.getPort()));
        }
    }
}
