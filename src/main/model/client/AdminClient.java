package model.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class AdminClient extends Client {

    public AdminClient(String name) {
        this.name = name.toUpperCase();
        adminStatus = true;
        adminClients.add(this);
    }

    //MODIFIES: listUser, user
    //EFFECTS: checks if list is too large

    public String getName() {
        return super.getName();
    }

    //MODIFIES: listUser, user
    //EFFECTS: checks if list is too large

    public void setName(String name) {
        super.setName(name);

    }
    //MODIFIES: listUser, user
    //EFFECTS: checks if list is too large

    public Boolean getStatus() {
        return this.adminStatus;

    }
    //MODIFIES: listUser, user
    //EFFECTS: checks if list is too large

    public String printStatus() {
        return super.printStatus();
    }







}
