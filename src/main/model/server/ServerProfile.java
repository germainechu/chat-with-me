package model.server;

import model.client.RegularClient;
import model.exceptions.SenderTooManyException;
import model.observer.ClientObserver;
import model.sendplay.Sender;

import java.util.ArrayList;
import java.util.List;

public class ServerProfile implements ClientObserver, Sender {

    private String name;
    private String type;
    private List<RegularClient> regularUsers = new ArrayList<>();

    public ServerProfile(String name, String type) {
        this.name = name.toUpperCase();
        this.type = type.toUpperCase();

    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name.toUpperCase();

    }

    @Override
     public void update(ServerProfile server) {
        System.out.println(server.getName() + "'s Client has gained administrative privileges.");

    }

    @Override
    public boolean checkContains(List<Sender> senders, Sender s) throws SenderTooManyException {

        if (senders.size() > 3) {
            throw new SenderTooManyException();
        }

        for (Sender u : senders) {
            if (u.getName().equals(s.getName())) {
                System.out.println(s.getName() + " is found!");
                return true;
            }
        }
        return false;
    }

  /*  public void addRegularUser(RegularClient r) {
        if (!regularUsers.contains(r)) {
            regularUsers.add(r);
            r.addServertoServers(this);
        }
    }*/


}

