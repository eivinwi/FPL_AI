package fpl_base;

@SuppressWarnings("unused")
public class Striker extends Player {

    public Striker(String name, String teamName) {
        super(name, teamName);
    }

    @Override
    public Util.PlayerType type() {
        return Util.PlayerType.STRIKER;
    }
}
