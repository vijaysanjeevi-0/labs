import java.net.*;
import java.util.*;

public class UdpDnsClient {
    public static void main(String[] a) throws Exception {
        System.out.print("Enter the hostname : ");
        byte[] h = new Scanner(System.in).nextLine().getBytes();
        DatagramSocket s = new DatagramSocket();
        s.send(new DatagramPacket(h, h.length, InetAddress.getLocalHost(), 1362));
        DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
        s.receive(p);
        System.out.println("IP Address: " + new String(p.getData(), 0, p.getLength()));
    }
}
