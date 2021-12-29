
import com.example.vvs.Server;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class listenClientsTest {
    Server server = new Server();

    @Test
    public void testListen() throws IOException {
        server.setPort(1234);
        server.acceptServerPort();
        int connection=server.conectionClient;
        assertEquals(0,connection);

    }
}
