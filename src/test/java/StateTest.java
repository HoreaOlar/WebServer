
import com.example.vvs.Server;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class StateTest {
    Server server =new Server();

    @Test
    public void test_set_getStatus() {
        server.setStateServer(1);
        assertEquals(1,server.getStateServer());
    }
}
