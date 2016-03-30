package fpl_base;

@SuppressWarnings("unused")
public class Defender extends Player {

    public Defender(String name, String teamName) {
        super(name, teamName);
    }

    @Override
    public Util.PlayerType type() {
        return Util.PlayerType.DEFENDER;
    }
}
