package fpl_base;

@SuppressWarnings("unused")
public class GoalKeeper extends Player {

    public GoalKeeper(String name, String teamName) {
        super(name, teamName);
    }

    @Override
    public Util.PlayerType type() {
        return Util.PlayerType.GOALKEEPER;
    }
}
