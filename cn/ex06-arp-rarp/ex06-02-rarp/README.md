# Ex 6.2 — RARP simulation (UDP)

**Aim:** Simulate RARP (MAC -> IP lookup) using UDP sockets.

**Apparatus / Tools required:** JDK (`javac`, `java`), two terminals.

**Algorithm — Server**
1. Datagram socket on port 1309, keep the IP/MAC table.
2. Receive a MAC, look up the IP, send it back (`Not found` if absent).

**Algorithm — Client**
1. Datagram socket; read the MAC from the user, send it.
2. Receive the datagram, display the IP.

**Procedure**
```bash
javac *.java
java ServerRarp        # terminal 1
java ClientRarp        # terminal 2
```

**Program**

`ServerRarp.java`
```java
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
```
`ClientRarp.java`
```java
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
```

**Sample Output**
```
Enter the Physical address (MAC):
6A:08:AA:C2
The Logical Address is(IP): 165.165.80.80
```

**Result:** RARP (MAC to IP resolution) was simulated over UDP sockets successfully.

## Notes
A `break` before `sendbyte=...` made the send code unreachable in the server — fixed.
