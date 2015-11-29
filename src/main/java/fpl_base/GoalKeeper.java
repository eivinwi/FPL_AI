package fpl_base;

/**
 * Created by eivwik on 05.11.15.
 */
public class GoalKeeper extends Player {

    public GoalKeeper(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "GKP";
    }
}
