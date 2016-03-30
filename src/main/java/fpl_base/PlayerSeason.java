package fpl_base;

@SuppressWarnings("unused")
public class PlayerSeason {

    private static final int rounds = 39;
    private int season; //year of first half of season. E.g 14/15 season == 2014

    private GameWeek[] gameWeeks = new GameWeek[rounds];

    // FPL
    private boolean[] played = new boolean[rounds];
    private double[] price = new double[rounds];
    private double[] ownedPercent = new double[rounds];
    private int[] points = new int[rounds];
    private double seasonStartPrice;
    private double seasonEndprice;

    public PlayerSeason(int season) {
        this.season = season;
    }

    public void addStats(int gw, String []stats) {
        if(gameWeeks[gw] != null) {
            gameWeeks[gw].setStats(stats);
        } else {
            gameWeeks[gw] = new GameWeek(stats);
        }
    }

    public void addStats(String []stats) {
        addStats(Integer.parseInt(stats[20]), stats);
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getSeason() {
        return season;
    }

    public static int getRounds() {
        return rounds;
    }

    public GameWeek getGameweek(int gw) {
        return gameWeeks[gw];
    }

    public int matchesPlayed(int gw) {
        int matches = 0;
        for(int i = 1; i < gw; i++) {
            if(gameWeeks[i].getMinutesPlayed() > 0) matches++;
        }
        return matches;
    }

    public int matchesPlayed() {
        return matchesPlayed(39);
    }

    /**
     * Player (non-FPL specific) statistics from previous seasons. These statistics contain metrics relevant for the
     * players position, as well as results against each oposing team.
     */
    class Statistics {


    }
}
