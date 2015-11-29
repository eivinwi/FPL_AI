package fpl_base;

/**
 * Created by eivwik on 05.11.15.
 */
public class Defender extends Player {

    public Defender(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "DEF";
    }
}
