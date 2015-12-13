package fpl_base;

@SuppressWarnings("unused")
public class Midfielder extends Player {

    public Midfielder(String name, double initialPrice) {
        super(name);
    }

    public Midfielder(String[] s) {
        super(s);
    }

    public String type() {
        return "MID";
    }
}
