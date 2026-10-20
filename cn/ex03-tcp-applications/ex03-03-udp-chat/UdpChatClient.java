import java.net.*;
import java.util.*;

public class UdpChatClient {
    public static void main(String[] a) throws Exception {
        DatagramSocket ds = new DatagramSocket(790);
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("Client: ");
            byte[] b = kb.nextLine().getBytes();
            ds.send(new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 789));
            if (new String(b).equals("end")) break;
            DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
            ds.receive(p);
            System.out.println("Server: " + new String(p.getData(), 0, p.getLength()));
        }
    }
}
