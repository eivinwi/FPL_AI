package fpl_base;

@SuppressWarnings("unused")
public class Midfielder extends Player {

    public Midfielder(String name, String teamName) {
        super(name, teamName);
    }

    @Override
    public Util.PlayerType type() {
        return Util.PlayerType.MIDFIELDER;
    }
}
