package service;

import fpl_base.Player;
import fpl_base.PlayerPool;

import java.util.HashMap;

/**
 * Created by eivwik on 07.12.15.
 */
public class PlayerService {

    PlayerPool players;

    public Player getPlayer(String name) {
        return players.getPlayer(name);
    }

    public HashMap<String, Player> getAllPlayers() {
        return players.getAllPlayers();
    }
}
