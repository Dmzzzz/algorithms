package patterns.observer.othervar2;

import java.util.ArrayList;
import java.util.List;

public class Observers {

    public static void main(String[] args) {
        Obs obs1 = new Obs("one");
        Obs obs2 = new Obs("two");

        obs1.setState("new state");
    }
}

class Obs {
    static List<Obs> obsList = new ArrayList<>();
    String name;
    String state;

    public Obs(String name) {
        this.name = name;
        obsList.add(this);
    }

    public void setState(String state) {
        this.state = state;
        notifyAllObs();
    }

    private void notifyAllObs() {
        for (Obs ob : obsList) {
            ob.update();
        }
    }

    public void update() {
        System.out.println(name + "change status " + state);
    }
}
