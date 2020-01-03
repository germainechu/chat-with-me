package model.observer;

import model.server.ServerProfile;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<ClientObserver> observers = new ArrayList<>();

    public Subject() {

    }

    public Subject(List<ClientObserver> observers) {
        this.observers = observers;
    }

    //MODIFIES: clientObserver
    //EFFECTS: addsObservers
    public void addObserver(ClientObserver clientObserver) {

        if (!observers.contains(clientObserver)) {
            observers.add(clientObserver);
        }
    }

//    //MODIFIES: observers
//    //EFFECTS: notifies list of observers
//    protected void notifyObservers(ServerProfile server) {
//        for (ClientObserver s : observers) {
//            s.update(server);
//        }
//    }

    public List<ClientObserver> getObservers() {
        return this.observers;
    }
}
