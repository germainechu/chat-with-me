

import model.exceptions.SenderTooManyException;
import model.exceptions.TooManyPlayersException;
import model.sendplay.Player;
import model.sendplay.Sender;
import model.client.RegularClient;
import model.server.ServerProfile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class RegularClientTest {

    private List<Sender> users = new ArrayList<>();
    private List<Player> players;
    private RegularClient r1;
    private RegularClient r2;
    private RegularClient r3;
    private ServerProfile server2;
    private Player pr1;
    private ServerProfile serverP;

    private HashMap<String, ServerProfile> mapD;



    @BeforeEach
    void setup() {
        server2 = new ServerProfile("SomeOtherName", "SomeType");
        serverP = new ServerProfile("Some", "Some");
        r1 = new RegularClient("Dwight",server2);
        r2 = new RegularClient("Jimothy",server2);
        r3  = new RegularClient("Michael",server2);
        pr1 = new RegularClient("Canton", server2);
        users.add(r1);
        users.add(r2);
        users.add(r3);
        players = new ArrayList<>();
        mapD = new HashMap<>();

    }

    @Test
    void testConstructor() {
        RegularClient regUser = new RegularClient("Canada",server2);
        assertEquals("canada".toUpperCase(), regUser.getName());
    }

    @Test
    void testCheckUsersDoesContains() throws SenderTooManyException {
        assertTrue(r1.checkContains(users,r1));
        assertTrue(true);

    }

    @Test
    void testCheckUsersDoesNotContains() throws SenderTooManyException {
        RegularClient u4 = new RegularClient("Angela",server2);
        assertFalse(u4.checkContains(users,u4));
    }

    @Test
    void testCheckUsersDoesNotContainsThenContains() throws SenderTooManyException {
        RegularClient u4 = new RegularClient("Miranda",server2);
        assertFalse(u4.checkContains(users,u4));
        users.add(u4);
        assertTrue(u4.checkContains(users,u4));
    }

    @Test
    void testChangeNameDoesContain() throws SenderTooManyException {
        RegularClient u4 = new RegularClient("Milly",server2);
        users.add(u4);
        assertTrue(u4.checkContains(users,u4));
        u4.setName("Bob");
        assertTrue(u4.checkContains(users,u4));
    }

    @Test
    void testAddPlayer(){
        RegularClient u5 = new RegularClient("Tired",server2);
        assertTrue(players.add(u5));
    }

    @Test
    void testAddPlayerNull() {
        RegularClient u5 = new RegularClient("Tired",server2);
        List<Player> nullList = new ArrayList<>();
        assertTrue(nullList.add(u5));

    }

    @Test
    void testCheckContainsThrowsBluetoothTooManyException() {
        try {
            RegularClient u4 = new RegularClient("Jim2",server2);
            RegularClient u5 = new RegularClient("Bob",server2);
            RegularClient u6  = new RegularClient("NonTam",server2);
            users.add(u4);
            users.add(u5);
            users.add(u6);
            u5.checkContains(users, u6);
        } catch (SenderTooManyException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testCheckContainsDoesNotThrowBluetoothTooManyException() {
        try {
            r3.checkContains(users, r1);
        } catch(SenderTooManyException e) {
            fail();
        }


    }

    @Test
    void testAddPlayersThrowsTooManyPlayersException() {
        Player p1 = new RegularClient("p1",server2);
        players.add(p1);
        players.add(new RegularClient("p2",server2));
        players.add(new RegularClient("p3",server2));
        players.add(new RegularClient("p5",server2));
        try {
            p1.addPlayers(players);
        } catch (TooManyPlayersException e) {
            players.remove(players.size() - 1);
        }
        finally {
            System.out.println(players.size());
        }
    }

    @Test
    void testAddPlayersDoesNotThrowTooManyPlayersException() {
        Player p1 = new RegularClient("p1",server2);
        players.add(p1);
        players.add(new RegularClient("p2",server2));
        players.add(new RegularClient("p3",server2));
        try {
            p1.addPlayers(players);
            Player p2 = new RegularClient("some",server2);
            p1.addPlayers(players);
        } catch (TooManyPlayersException e) {
            fail();
        }
        finally {
            System.out.println(players.size());
            assertTrue(players.size() <= 5);
        }
    }



    @Test
    void testAddPlayersThrowsException() {
        try {
            Player p2 = new RegularClient("some",server2);
            p2.addPlayers(players);
            assertTrue(players.contains(p2));
            assertEquals(1,players.size());
            Player p3 = new RegularClient("some2",server2);
            p3.addPlayers(players);
            assertEquals(2,players.size());
            assertTrue(players.contains(p3));
            Player p4 = new RegularClient("some3",server2);
            p4.addPlayers(players);
            assertTrue(players.contains(p4));
            assertEquals(3,players.size());
            Player p5 = new RegularClient("some4",server2);
            p5.addPlayers(players);
            assertTrue(players.contains(p5));
            assertEquals(4,players.size());
            Player p6 = new RegularClient("some5",server2);
            p6.addPlayers(players);
            assertTrue(players.contains(p6));
            assertEquals(5,players.size());

            //should try exception here
            Player p7 = new RegularClient("some6",server2);
            p7.addPlayers(players);
            assertTrue(players.contains(p7));
            assertEquals(6,players.size());

            fail();

        } catch (TooManyPlayersException e){
            System.out.println("TooManyPlayersException caught");
        }

    }

    @Test
    void testAddPlayersDoesNotThrowException(){
        try {
            r1.removePlayer(players);
            r2.removePlayer(players);
            System.out.println(players.size());
            r2.addPlayers(players);

        } catch (TooManyPlayersException e){
            fail();
        }
    }

    @Test
    void testPlayerConstructor() {
        assertTrue(pr1.getNamePlayer().equals("Canton".toUpperCase()));
    }


    @Test
    void testPrintStatus() {
        assertEquals("You have regular user privileges.",r1.printStatus());
    }







}

