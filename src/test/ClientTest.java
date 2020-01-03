

import model.client.AdminClient;
import model.client.RegularClient;
import model.client.Client;
import model.server.ServerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ClientTest {

    private Client adminClient;
    private Client regularClient;


    @BeforeEach
    void setup() {
        ServerProfile serverProfile = new ServerProfile("Blah", "ashd");
        adminClient = new AdminClient("Eragon");
        regularClient = new RegularClient("Elf", serverProfile);

    }

    @Test
    void testSetName() {
        adminClient.setName("Eragon");
        assertTrue(adminClient.getName().equals("Eragon"));
        adminClient.setName("Bob");
        assertTrue(adminClient.getName().equals("Bob"));

    }

    @Test
    void testSetNameRegularUser() {
        regularClient.setName("Jimothy");
        assertTrue(regularClient.getName().equals("Jimothy"));
        regularClient.setName("Anthony");
        assertTrue(regularClient.getName().equals("Anthony"));


    }

    @Test
    void testPrintStatusAdminUser() {
        adminClient.printStatus();
        assertEquals("You now have administrative privileges.", adminClient.printStatus());
        regularClient.printStatus();
        assertEquals("You have regular user privileges.", regularClient.printStatus());
    }


}
