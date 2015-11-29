package fpl_base;

/**
 * Created by eivwik on 05.11.15.
 */
public class Striker extends Player {

    public Striker(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "FWD";
    }
}
