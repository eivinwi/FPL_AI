package fpl_base;

@SuppressWarnings("unused")
public class Defender extends Player {

    public Defender(String name, double initialPrice) {
        super(name, initialPrice);
    }

    public String type() {
        return "DEF";
    }
}
