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
