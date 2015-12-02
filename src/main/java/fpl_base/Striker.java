package fpl_base;

@SuppressWarnings("unused")
public class Striker extends Player {

    public Striker(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "FWD";
    }
}
