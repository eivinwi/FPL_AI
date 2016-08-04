package rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fpl_base.League;
import fpl_base.Player;
import fpl_base.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.PlayerService;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

@Controller
public class PlayerRestService {

    @Autowired
    private PlayerService players;
    @Autowired
    private League league;

    @RequestMapping(value = "/players/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Player getPlayer(@PathVariable String name) {
        return players.getPlayer(name);
    }

    @RequestMapping(value = "/teams/{teamName}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Stream<Player> getTeamPlayers(@PathVariable String teamName) {
        if(league.hasTeam(teamName)) {
            return league.getTeam(teamName).getPlayers();
        }
        return null;
    }

    @RequestMapping(value = "/players",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String,Player> getAllPlayers() {
        try {
            return players.getAllPlayers();
        } catch (Exception e) {
            System.err.println("Error while serializing players");
        }
        return null;
    }

    @RequestMapping(value = "/players/test",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Player test() {
        try {
            return players.getPlayer("Henderson");
        } catch (Exception e) {
            System.err.println("Error while serializing players");
        }
        return null;
    }


}
