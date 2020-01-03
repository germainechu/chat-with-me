package model.observer;

import model.server.ServerProfile;

public interface ClientObserver {

    void update(ServerProfile server);
}
