package fpl_base;

import java.util.HashMap;
import java.util.HashSet;

@SuppressWarnings("unused")
public class PlayerPool {
    HashMap<String, Player> players;
    HashSet<Player> pool = new HashSet<Player>();

    public PlayerPool(HashMap<String, Player> players) {
        this.players = players;
    }

    public PlayerPool() {
        this.players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        if(players.containsKey(player.getName().toLowerCase())) {
            System.out.println("fpl_base.Player " + player.getName() + " allready in pool, skipping");
        } else {
            players.put(player.getName().toLowerCase(), player);
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

}
