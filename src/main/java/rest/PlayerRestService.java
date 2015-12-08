package rest;

import fpl_base.Player;
import org.codehaus.jackson.map.ObjectMapper;
import service.PlayerService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/players")
public class PlayerRestService {
    PlayerService players;

    @GET
    @Produces("application/json")
    public Player getPlayer(@PathParam("name") String name) {
        return players.getPlayer(name);
    }

    @GET
    @Produces("application/json")
    public String getAllPlayers() {
        String json = "";
        try {
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(players.getAllPlayers());
        } catch (Exception e) {
            System.err.println("Error while serializing players");
        }
        return json;
    }

}
