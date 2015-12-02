package fpl_base;

@SuppressWarnings("unused")
public class GoalKeeper extends Player {

    public GoalKeeper(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "GKP";
    }
}
