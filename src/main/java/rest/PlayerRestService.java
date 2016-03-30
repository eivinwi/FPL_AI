package rest;

import fpl_base.League;
import fpl_base.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.PlayerService;

import java.util.Collection;
import java.util.Map;

@Controller
public class PlayerRestService {

    @Autowired
    private PlayerService players;
    @Autowired
    private League league;

    @RequestMapping(value = "/players/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Player getPlayer(@RequestParam String name) {
        return players.getPlayer(name);
    }
/*
    @RequestMapping(value = "/team",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getTeamPlayers(@RequestParam String teamName) {
        String json = "";
        if(league.hasTeam(teamName)) {
            try {
                ObjectMapper om = new ObjectMapper();
                json = om.writeValueAsString(league.getTeam(teamName).getPlayers());
            } catch (IOException e) {
                System.err.println("Error while serializing team: " + teamName);
                json = "";
            }
        }
        return json;
    }*/

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
