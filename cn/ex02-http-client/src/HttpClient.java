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
