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
        if(p.getTeamName().equals(home.getName()) && !homePlayers.contains(p)) {
            homePlayers.add(p);
        } else if(p.getTeamName().equals(away.getName()) && !awayPlayers.contains(p)) {
            awayPlayers.add(p);
        }
    }

    public Team getHomeTeam() {
        return home;
    }

    public Team getAwayTeam() {
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

    public int getPoints(String teamName) {
        if(teamName.equals(home.getName())) {
            if(homeScore > awayScore) return 3;
            else return (homeScore == awayScore)? 1 : 0;
        } else if(teamName.equals(away.getName())) {
            if(homeScore < awayScore) return 3;
            else return (homeScore == awayScore)? 1 : 0;
        }
        System.err.format("Team %s is not a part of the match %s-%s\n", teamName, home.getName(), away.getName());
        return 0;
    }

    public int getPoints(boolean forHome) {
        return (forHome)? getPoints(home.getName()) : getPoints(away.getName());
    }

    public int getPoints(Team t) {
        return getPoints(t.getName());
    }




    private class Statistics {
        //Todo: fetch general match stats
        // ie: possession, shots on goal etc


    }


}
