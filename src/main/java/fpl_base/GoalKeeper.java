package fpl_base;

@SuppressWarnings("unused")
public class GoalKeeper extends Player {

    public GoalKeeper(String name, double initialPrice) {
        super(name);
    }

    public GoalKeeper(String[] s) {
        super(s);
    }

    public String type() {
        return "GKP";
    }
}
