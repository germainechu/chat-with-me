import model.client.AdminClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminClientTest {

    AdminClient ac;

    @BeforeEach
    public void setup() {
        ac = new AdminClient("Canada");
    }

    @Test
    public void testConstructor() {
        assertEquals("Canada".toUpperCase(), ac.getName());
        assertTrue(ac.getStatus());
        assertEquals(1, ac.adminClients.size());
    }

    @Test
    public void testPrintStatus() {
        assertEquals("You now have administrative privileges.",ac.printStatus());
    }



}
