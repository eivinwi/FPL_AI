package fpl_base;


import java.util.List;

public class Match {
    private Team home;
    private Team away;
    private int homeScore;
    private int awayScore;

    private List<Player> homePlayers;
    private List<Player> awayPlayers;

    public Match() {

    }

    public void addPlayer(Player p) {
        if(p.getTeam().equals(home) && !homePlayers.contains(p)) {
            homePlayers.add(p);
        } else if(p.getTeam().equals(away) && !awayPlayers.contains(p)) {
            awayPlayers.add(p);
        }
    }

    public Team getHome() {
        return home;
    }

    public Team getAway() {
        return away;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public List<Player> getHomePlayers() {
        return homePlayers;
    }


    public List<Player> getAwayPlayers() {
        return awayPlayers;
    }

    public int getPoints(String name) {
        if(name.equals(home.getName())) {
            if(homeScore > awayScore) return 3;
            else return (homeScore == awayScore)? 1 : 0;
        } else if(name.equals(away.getName())) {
            if(homeScore < awayScore) return 3;
            else return (homeScore == awayScore)? 1 : 0;
        }
        System.err.format("Team %s is not a part of the match %s-%s\n", name, home.getName(), away.getName());
        return 0;
    }

    public int getPoints(Team t) {
        return getPoints(t.getName());
    }




    private class Statistics {
        //Todo: fetch general match stats
        // ie: possession, shots on goal etc


    }


}
