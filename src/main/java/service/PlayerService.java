package service;

import fpl_base.Player;
import fpl_base.PlayerPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * Created by eivwik on 07.12.15.
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerPool players;

    public Player getPlayer(String name) {
        return players.getPlayer(name);
    }

    public HashMap<String, Player> getAllPlayers() {
        return players.getAllPlayers();
    }
}
