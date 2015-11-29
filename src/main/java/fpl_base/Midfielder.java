package fpl_base;

/**
 * Created by eivwik on 05.11.15.
 */
public class Midfielder extends Player {

    public Midfielder(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "MID";
    }
}
