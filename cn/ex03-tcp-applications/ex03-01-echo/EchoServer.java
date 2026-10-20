import java.net.*;

public class EchoServer {
    public static void main(String[] a) throws Exception {
        Socket c = new ServerSocket(9000).accept();
        c.getInputStream().transferTo(c.getOutputStream());
    }
}
