package fpl_base;

@SuppressWarnings("unused")
public class Defender extends Player {

    public Defender(String name, double initialPrice) {
        super(name);
    }

    public Defender(String[] s) {
        super(s);
    }

    public String type() {
        return "DEF";
    }
}
