# Ex 3.2 — File transfer over TCP

**Aim:** Transfer a file from server to client over a TCP socket.

**Apparatus / Tools required:** JDK (`javac`, `java`), two terminals, a sample file to transfer.

**Algorithm — Server**
1. Create `ServerSocket(5000)` and accept a client.
2. Open the requested file and copy its bytes to the socket's output stream.
3. Close the socket.

**Algorithm — Client**
1. Connect to the server.
2. Read bytes from the socket until end of stream.
3. Write them to the output file.
4. Close.

**Procedure**
```bash
javac *.java
java FileServer somefile.html          # terminal 1
java FileClient received.html          # terminal 2
```

**Program**

`FileServer.java`
```java
import java.net.*;
import java.nio.file.*;

public class FileServer {
    public static void main(String[] a) throws Exception {
        Socket s = new ServerSocket(5000).accept();
        Files.copy(Path.of(a[0]), s.getOutputStream());
        s.close();
        System.out.println("File sent successfully!");
    }
}
```
`FileClient.java`
```java
import java.net.*;
import java.nio.file.*;

public class FileClient {
    public static void main(String[] a) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Files.copy(s.getInputStream(), Path.of(a[0]), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File saved successfully!");
    }
}
```

**Sample Output:** `received.html` is created and is byte-identical to `somefile.html`.

**Result:** A file was transferred from server to client over TCP successfully.

## Notes
Missing `;` after an import; hard-coded `e:\` paths replaced with command-line arguments. Verified byte-identical on a 55 KB file.
