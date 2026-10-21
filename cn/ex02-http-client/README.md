# Ex 2 — HTTP web client using TCP sockets

**Aim:** Write a Java HTTP client that downloads a web page over a TCP socket.

**Apparatus / Tools required:** JDK (`javac`, `java`), a web server to test against (a local one, or any plain-HTTP site).

**Algorithm**
1. Start.
2. Create a TCP socket to the web server (host, port 80).
3. Send an HTTP request: `GET <path> HTTP/1.0`, `Host: <host>`, blank line.
4. Read the response until the server closes the connection.
5. Split the status line and headers from the body at the blank line (`\r\n\r\n`).
6. Save the body to `downloaded.html`.
7. Close the socket. Stop.

**Procedure**
```bash
cd src && javac *.java

# offline test: two terminals
python3 -m http.server 8080              # terminal 1 (any local web server works)
java HttpClient localhost 8080           # terminal 2

# real site (plain HTTP only, no HTTPS)
java HttpClient example.com
```

**Program**
```java
import java.net.*;
import java.nio.file.*;

public class HttpClient {
    public static void main(String[] a) throws Exception {
        String host = a.length > 0 ? a[0] : "example.com";
        try (Socket s = new Socket(host, a.length > 1 ? Integer.parseInt(a[1]) : 80)) {
            s.getOutputStream().write(("GET / HTTP/1.0\r\nHost: " + host + "\r\n\r\n").getBytes());
            String r = new String(s.getInputStream().readAllBytes());
            Files.writeString(Path.of("downloaded.html"), r.substring(r.indexOf("\r\n\r\n") + 4));
            System.out.println(r.split("\r\n")[0]);
        }
    }
}
```

**Sample Output**
```
HTTP/1.0 200 OK
```
The page body is saved to `downloaded.html`.

**Result:** A Java HTTP client was implemented and used to download a web page over a TCP socket successfully.

## Notes
The manual's original program transferred an image over a raw socket, which is not HTTP and does not match the title; this version speaks real HTTP/1.0. HTTPS needs TLS (`SSLSocket`) and is out of scope.

## Viva
See [VIVA.md](VIVA.md) for exercise-specific questions with answers. General questions are in the [base VIVA.md](../VIVA.md).
