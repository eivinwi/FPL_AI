package fpl_base.Calculations;

import fpl_base.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by eivwik on 09.01.16.
 */
public class FplTeamRoundTest {

    @Test
    public void testSetFormation() throws Exception {


    }

/*    @Test
    public void testGetOptimalPoints() throws Exception {
        List<Player> team = new ArrayList<>();
        team.add( new GoalKeeper(createGwPlayer("Mignolet", "7")) );
        team.add( new GoalKeeper(createGwPlayer("Bogdan", "3")) );

        team.add( new Defender(createGwPlayer("Sakho", "5")) );
        team.add( new Defender(createGwPlayer("Skrtel", "7")) );
        team.add( new Defender(createGwPlayer("Moreno", "0")) );
        team.add( new Defender(createGwPlayer("Clyne", "2")) );
        team.add( new Defender(createGwPlayer("Gomez", "0")) );

        team.add( new Midfielder(createGwPlayer("Milner", "2")) );
        team.add( new Midfielder(createGwPlayer("Coutinho", "6")) );
        team.add( new Midfielder(createGwPlayer("Henderson", "3")) );
        team.add( new Midfielder(createGwPlayer("Firminho", "11")) );
        team.add( new Midfielder(createGwPlayer("Allen", "1")) );

        team.add( new Striker(createGwPlayer("Sturridge", "15")) );
        team.add( new Striker(createGwPlayer("Origi", "11")) );
        team.add( new Striker(createGwPlayer("Ings", "9" )) );


        FplTeamRound ftr = new FplTeamRound(1, team);

        List<Player> bestTeam = ftr.getOptimalPoints(false, false, false);
        int pts = 0;
        for(Player p : bestTeam) {
            pts += p.getPoints(1);
        }
        assertEquals("Total amount of points should be correct", 78, pts);

        List<Player> bestTeam2 = ftr.getOptimalPoints(true, false, false);
        pts = 0;
        for(Player p : bestTeam2) {
            pts += p.getPoints(1);
        }
        assertEquals("Total amount of points should be correct", 82, pts);


        List<Player> bestTeam3 = ftr.getOptimalPoints(false, true, false);
        pts = 0;
        for(Player p : bestTeam3) {
            pts += p.getPoints(1);
        }
        assertEquals("Total amount of points should be correct", 78, pts);



    }


    private String[] createGwPlayer(String name, String points) {
        return new String[] {name, "90", "0", "0", "0", "0", "0", "0", "0", "0",
                "0", "0", "0", "0", "0", points, "LIV", "3-1", "EVE", "home", "1",
                "GK", "0", "", "0", "0.0", "", "", "0.0", "0.0"};
    }*/
}