import java.net.*;
import java.util.*;

public class ClientRarp {
    public static void main(String[] a) throws Exception {
        System.out.println("Enter the Physical address (MAC):");
        byte[] m = new Scanner(System.in).nextLine().getBytes();
        DatagramSocket s = new DatagramSocket();
        s.send(new DatagramPacket(m, m.length, InetAddress.getLocalHost(), 1309));
        DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
        s.receive(p);
        System.out.println("The Logical Address is(IP): " + new String(p.getData(), 0, p.getLength()));
    }
}
