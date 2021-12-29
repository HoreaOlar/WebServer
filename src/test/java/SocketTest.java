
import com.example.vvs.Server;
import org.junit.jupiter.api.Test;

import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class SocketTest {
    Server server =new Server();

    @Test
    public void test_set_getSocketClient() {
        Socket sock = new Socket();
        server.setClientSocket(sock);
        assertEquals(sock,server.getClientSocket());
    }
}
