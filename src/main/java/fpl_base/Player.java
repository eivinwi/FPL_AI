package fpl_base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Player implements Comparable {
    @JsonIgnore
    private static final int rounds = 39; //38+1 to avoid having to constantly convert gameweek to n-1 for arrays

    private String name;
    private String teamName; //TODO: set

    private List<PlayerSeason> seasons;

    // FPL
    private boolean[] played = new boolean[rounds];
    private double[] price = new double[rounds];
    private double[] ownedPercent = new double[rounds];
    private int[] points = new int[rounds];
    private double seasonStartPrice;
    private double seasonEndprice;

    public Player(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        seasons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void addStats(int season, String []stats) {
        PlayerSeason ps = getSeason(season);
        if(ps == null) {
            seasons.add(new PlayerSeason(season));
        }
        ps = getSeason(season);
        ps.addStats(stats);
    }

    public void addStats(String []stats) {
        addStats(Util.CURRENT_SEASON, stats);
    }

    public Util.PlayerType type() {
        return Util.PlayerType.NONE;
    }

    public void addSeason(PlayerSeason season) {
        this.seasons.add(season);
    }

    public List<PlayerSeason> getSeasons() {
        return seasons;
    }

    public boolean playedSeason(int season) {
        return getSeason(season) != null;
    }

    public PlayerSeason getSeason(int season) {
        for(PlayerSeason ps : seasons) {
            if(ps.getSeason() == season) {
                return ps;
            }
        }
        return null;
    }

    public PlayerSeason currentSeason() {
        return seasons.get(Util.CURRENT_SEASON);
    }

    public GameWeek getGameweek(int season, int gw) {
        PlayerSeason ps = seasons.get(season);
        return (ps != null)? ps.getGameweek(gw) : null;
    }

    public GameWeek getGameWeek(int gw) {
        return getGameweek(Util.CURRENT_SEASON, gw);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


}
