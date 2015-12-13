package fpl_base;

import java.util.HashMap;
import java.util.LinkedList;

@SuppressWarnings("unused")
public class PlayerPool {
    HashMap<String, Player> players;
   // HashSet<Player3> pool = new HashSet<Player3>();

    private LinkedList<GoalKeeper> goalKeepers;
    private LinkedList<Defender> defenders;
    private LinkedList<Midfielder> midfielders;
    private LinkedList<Striker> strikers;

    public PlayerPool(HashMap<String, Player> players) {
        this.players = players;
        this.goalKeepers = new LinkedList<>();
        this.defenders = new LinkedList<>();
        this.midfielders = new LinkedList<>();
        this.strikers = new LinkedList<>();
    }

    public PlayerPool() {
        this.players = new HashMap<>();
        this.goalKeepers = new LinkedList<>();
        this.defenders = new LinkedList<>();
        this.midfielders = new LinkedList<>();
        this.strikers = new LinkedList<>();
    }

    public LinkedList<GoalKeeper> getGoalKeepers() {
        return goalKeepers;
    }

    public LinkedList<Defender> getDefenders() {
        return defenders;
    }

    public LinkedList<Midfielder> getMidfielders() {
        return midfielders;
    }

    public LinkedList<Striker> getStrikers() {
        return strikers;
    }


    public void addPlayer(Player player) {
        if(players.containsKey(player.getName().toLowerCase())) {
            System.out.println("fpl_base.Player3 " + player.getName() + " already in pool, skipping");
        } else {
            players.put(player.getName().toLowerCase(), player);
            if(player instanceof GoalKeeper) goalKeepers.add((GoalKeeper) player);
            else if(player instanceof Defender) defenders.add((Defender) player);
            else if(player instanceof Midfielder) midfielders.add((Midfielder) player);
            else if(player instanceof Striker) strikers.add((Striker) player);
        }
    }

    public Player getPlayer(String name) {
        return players.get(name.toLowerCase());
    }

    public boolean hasPlayer(String name) {
        return players.containsKey(name.toLowerCase());
    }

    public boolean hasPlayer(Player player) {
        return players.containsKey(player.getName().toLowerCase());
    }

    public HashMap<String, Player> getAllPlayers() {
        return players;
    }

}
