import java.net.*;
import java.util.*;

public class UdpChatServer {
    public static void main(String[] a) throws Exception {
        DatagramSocket ds = new DatagramSocket(789);
        Scanner kb = new Scanner(System.in);
        while (true) {
            DatagramPacket p = new DatagramPacket(new byte[1024], 1024);
            ds.receive(p);
            String msg = new String(p.getData(), 0, p.getLength());
            if (msg.equals("end")) break;
            System.out.println("Client: " + msg);
            System.out.print("Server: ");
            byte[] b = kb.nextLine().getBytes();
            ds.send(new DatagramPacket(b, b.length, InetAddress.getLocalHost(), 790));
        }
    }
}
