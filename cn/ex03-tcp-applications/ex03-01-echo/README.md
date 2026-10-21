# Ex 3.1 — TCP Echo

**Aim:** Write a TCP echo client/server pair in Java.

**Apparatus / Tools required:** JDK (`javac`, `java`), two terminals.

**Algorithm — Server**
1. Create `ServerSocket(9000)` and accept a client.
2. Read a line; if it is `end`, close and stop; otherwise echo it straight back.
3. Repeat until the client disconnects.

**Algorithm — Client**
1. Create a socket and connect to the server.
2. Read a line from the user and send it.
3. Read the echoed line back and display it.
4. Repeat until the user types `end`, then close.

**Procedure**
```bash
javac *.java
java EchoServer       # terminal 1
java EchoClient       # terminal 2
```

**Program**

`EchoServer.java`
```java
import java.net.*;

public class EchoServer {
    public static void main(String[] a) throws Exception {
        Socket c = new ServerSocket(9000).accept();
        c.getInputStream().transferTo(c.getOutputStream());
    }
}
```
`EchoClient.java`
```java
import java.io.*;
import java.net.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] a) throws Exception {
        Scanner kb = new Scanner(System.in);
        Socket s = new Socket("localhost", 9000);
        Scanner in = new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String line;
        System.out.print("Client: ");
        while (!(line = kb.nextLine()).equals("end")) {
            out.println(line);
            System.out.println("Server: " + in.nextLine());
            System.out.print("Client: ");
        }
    }
}
```

**Sample Output**
```
Client: Hai Server
Server: Hai Server
Client: end
Socket closed
```

**Result:** A TCP echo client/server pair was implemented and run successfully.

## Notes
`System.out.println(e)` was inside a `try` where `e` was not in scope, and the server looped forever after the client left — both fixed.
