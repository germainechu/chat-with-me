package model.client;


import model.observer.Subject;


import java.util.ArrayList;
import java.util.List;

public abstract class Client extends Subject {

    Boolean adminStatus;
    public List<AdminClient> adminClients = new ArrayList<>();
    List<RegularClient> regularClients = new ArrayList<>();
    String name;



    //MODIFIES: listUser, user
    //EFFECTS: returns name
    public String getName() {
        return this.name;
    }

    //MODIFIES: listUser, user
    //EFFECTS: sets name
    public void setName(String name) {
        this.name = name;
        System.out.println("This user's name is: " + name);
    }

    //MODIFIES: listUser, user
    //EFFECTS: prints status
    public String printStatus() {
        if (adminStatus) {
            return "You now have administrative privileges.";
        } else {
            return "Unfortunately, you do not have administrative privileges";
        }
    }

}
