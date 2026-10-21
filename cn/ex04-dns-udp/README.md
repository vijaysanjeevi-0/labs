# Ex 4 — Simulation of DNS using UDP sockets

**Aim:** Write a Java program that simulates DNS name-to-IP resolution over UDP.

**Apparatus / Tools required:** JDK (`javac`, `java`), two terminals.

**Algorithm — Server**
1. Create a UDP datagram socket on port 1362 and a table mapping host names to IP addresses.
2. Receive a host name from a client, read its address/port from the datagram.
3. Look the host name up (`Host Not Found` if absent).
4. Display the request and send the IP address back.
5. Repeat from step 2.

**Algorithm — Client**
1. Create a UDP datagram socket.
2. Read a host name from the user and send it to the server.
3. Wait for the reply datagram and display the IP address.

**Procedure**
```bash
cd src && javac *.java
java UdpDnsServer                    # terminal 1
java UdpDnsClient                    # terminal 2
```

**Program**

`UdpDnsServer.java`
```java
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
```
`UdpDnsClient.java`
```java
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
```

**Sample Output**
```
Enter the hostname : yahoo.com
IP Address: 68.180.206.184
Enter the hostname : cricinfo.com
IP Address: 80.168.92.140
Enter the hostname : youtube.com
IP Address: Host Not Found
```

**Result:** DNS name-to-IP resolution was simulated over UDP sockets successfully.

## Notes
The server created a new `DatagramSocket(1362)` inside the loop, and compared the whole 1021-byte buffer instead of only the received bytes — both fixed.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
