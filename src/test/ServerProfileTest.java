import model.client.RegularClient;
import model.exceptions.SenderTooManyException;
import model.sendplay.Sender;
import model.server.ServerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class ServerProfileTest {
    private ServerProfile p;

    @BeforeEach
    void setup() {
        p = new ServerProfile("Bob", "Something");
    }

    @Test
    void testConstructor() {
        assertEquals("BOB", p.getName());
        assertEquals("SOMETHING", p.getType());
    }

    @Test
    void testSetName() {
        assertEquals("BOB", p.getName());
        p.setName("Jim");
        assertEquals("JIM", p.getName());
    }

    @Test
    void testCheckContainsThrowsException() {
        List<Sender> senders = new ArrayList<>();
        Sender s = new RegularClient("Jim", p);

        for (int i=0; i<4; i++) {
            senders.add(new RegularClient(i + " name", p));
        }

        try {
            p.checkContains(senders, s);
        } catch (SenderTooManyException e) {
            System.out.println(e.toString());
        }
    }

    @Test
    void testCheckContainsDoesNotThrowException() {
        List<Sender> senders = new ArrayList<>();
        Sender s = new RegularClient("Jim", p);

        senders.add(new RegularClient("some", p));
        senders.add(s);
        try {
            assertTrue(senders.size() <= 3);
            p.checkContains(senders,s);
            assertTrue(p.checkContains(senders,s));
        } catch (SenderTooManyException e) {
            fail();
        }

    }


}
