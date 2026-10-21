# Ex 3.3 — UDP chat

**Aim:** Two-way chat between a client and server using UDP datagrams.

**Apparatus / Tools required:** JDK (`javac`, `java`), two terminals.

**Algorithm — Server**
1. Create a datagram socket on port 789.
2. Receive a request; if it is `end`, stop.
3. Display it, read a reply from the keyboard, send it to the client (port 790).
4. Repeat from step 2.

**Algorithm — Client**
1. Create a datagram socket on port 790.
2. Read a message, send it to the server (port 789); if it was `end`, stop.
3. Otherwise receive and display the reply.
4. Repeat from step 2.

**Procedure**
```bash
javac *.java
java UdpChatServer    # terminal 1
java UdpChatClient    # terminal 2
```

**Program**

`UdpChatServer.java`
```java
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
```
`UdpChatClient.java`
```java
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
```

**Sample Output:** messages typed on one side are received and displayed on the other, in both directions, until `end` is sent.

**Result:** Two-way UDP chat between a client and server was implemented and run successfully.

## Notes
`buffer = str.getBytes()` shrank the receive buffer, truncating later messages (manual's own output shows "Hello Clie") — fixed by using a fresh 1024-byte buffer each receive. `geyLocalHost` typo fixed.
