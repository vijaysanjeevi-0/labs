import java.net.*;
import java.nio.file.*;

public class FileClient {
    public static void main(String[] a) throws Exception {
        Socket s = new Socket("localhost", 5000);
        Files.copy(s.getInputStream(), Path.of(a[0]), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("File saved successfully!");
    }
}
