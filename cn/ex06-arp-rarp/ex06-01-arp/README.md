# Ex 6.1 — ARP simulation (TCP)

**Aim:** Simulate ARP (IP -> MAC lookup) using TCP sockets.

**Apparatus / Tools required:** JDK (`javac`, `java`), two terminals.

**Algorithm — Server**
1. `ServerSocket` on port 9139, keep a table of IP/MAC pairs.
2. Accept a client, receive an IP, look up the MAC.
3. Send it back (`Not found` if absent), then go back to listening.

**Algorithm — Client**
1. Connect, read an IP from the user, send it.
2. Receive the MAC, display it, close.

**Procedure**
```bash
javac *.java
java ServerArp         # terminal 1
java ClientArp         # terminal 2
```

**Program**

`ServerArp.java`
```java
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
```
`ClientArp.java`
```java
import java.io.*;
import java.net.*;
import java.util.*;

public class ClientArp {
    public static void main(String[] a) throws Exception {
        System.out.println("Enter the Logical address(IP):");
        Socket s = new Socket("localhost", 9139);
        new PrintWriter(s.getOutputStream(), true).println(new Scanner(System.in).nextLine());
        System.out.println("The Physical Address is: " + new Scanner(s.getInputStream()).nextLine());
    }
}
```

**Sample Output**
```
Enter the Logical address(IP):
165.165.80.80
The Physical Address is: 6A:08:AA:C2
```

**Result:** ARP (IP to MAC resolution) was simulated over TCP sockets successfully.

## Notes
`obj.close()` was inside `while(true)` and no reply was sent for an unknown IP, so the client hung — fixed. Port 139 (NetBIOS) is reserved on Windows, so 9139 is used.
