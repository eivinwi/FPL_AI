package fpl_base;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Eivind on 28.11.2015.
 */
public class MainTest {

    @Before
    public void setup() {
        Main.setup();
    }

    @Test
    public void shouldHaveAllGameWeeks() {
        assertNotNull(Main.players);
        for(Team t : Main.league.getTeams()) {
            assertEquals("All teams should have played 38 matches.", 38, t.totalMatches());
        }
    }
}