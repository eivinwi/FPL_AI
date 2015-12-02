package fpl_base;

@SuppressWarnings("unused")
public class Midfielder extends Player {

    public Midfielder(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "MID";
    }
}
