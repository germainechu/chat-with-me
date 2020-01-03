package model.client;


import model.exceptions.SenderTooManyException;
import model.exceptions.TooManyPlayersException;
import model.observer.ClientObserver;
import ui.threads.Server;
import model.server.ServerProfile;
import model.sendplay.*;


import java.util.*;


public class RegularClient extends Client implements Player, Sender {

    private ServerProfile serverProfile;
    private ClientObserver co;
    private List<ServerProfile> servers = new ArrayList<>();
    public HashMap<ServerProfile, Server> serverMap = new HashMap<>();


    public RegularClient(String name, ServerProfile s) {
        this.name = name.toUpperCase();
        adminStatus = false;
        this.serverProfile = s;
        addObserver(co);
    }

    //MODIFIES: listUser, user
    //EFFECTS: gets name
    @Override
    public String getName() {
        return this.name;
    }

    //MODIFIES: this
    //EFFECTS: checks name
    public void setName(String name) {
        super.setName(name);
    }

    //MODIFIES: listUser, user
    //EFFECTS: checks if list is too large
    @Override
    public String printStatus() {
        return "You have regular user privileges.";
    }


    //MODIFIES: listUser, user
    //EFFECTS: checks if list is too large
    @Override
    public boolean checkContains(List<Sender> listUser, Sender user)
            throws SenderTooManyException {

        if (listUser.size() > 5) {
            throw new SenderTooManyException();
        } else {
            for (Sender u: listUser) {
                if (u.getName().equals(user.getName())) {
                    System.out.println(u.getName() + " is found!");
                    return true;
                }
            }
            return false;
        }

    }
    //MODIFIES: players, user
    //EFFECTS: adds players to the list

    @Override
    public Boolean addPlayers(List<Player> users) throws TooManyPlayersException {

        if (users.size() >= 5) {
            throw new TooManyPlayersException();

        } else {
            users.add(this);
            System.out.println(getNamePlayer() + " is playing now.");
        }

        return true;
    }
    //MODIFIES: listUser, user
    //EFFECTS: removes if list is too large

    public void removePlayer(List<Player> players) {
        players.remove(this);
    }

    //MODIFIES:
    //EFFECTS: returns this

    @Override
    public String getNamePlayer() {
        return this.name;

    }



}

