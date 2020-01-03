import model.observer.ClientObserver;
import model.observer.Subject;
import model.server.ServerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SubjectTest {

    private List<ClientObserver> observers= new ArrayList<>();
    private ClientObserver co;
    private Subject s;

    @BeforeEach
    void setup() {
        s = new Subject(observers);

        co = new ServerProfile("Some", "local");
    }

    @Test
    void testAddObserver(){
        s.addObserver(co);
        assertTrue(s.getObservers().contains(co));
        s.addObserver(co);
        assertEquals(1, s.getObservers().size());
    }




}
