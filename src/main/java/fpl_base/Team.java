package fpl_base;

import java.util.*;
import java.util.stream.Collectors;

@SuppressWarnings("unused")
public class Team implements Comparable<Team> {
    private String name;
    private ArrayList<GoalKeeper> goalKeepers;
    private ArrayList<Defender> defenders;
    private ArrayList<Midfielder> midfielders;
    private ArrayList<Striker> strikers;

    //HashMap<Double, TeamStats> stats;
    TeamStats[] stats;
    Match[] matches;

    private int points;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name) {
        this.name = name;
        goalKeepers = new ArrayList<>();
        defenders = new ArrayList<>();
        midfielders = new ArrayList<>();
        strikers = new ArrayList<>();
        //stats = new HashMap<>();
        stats = new TeamStats[39];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<GoalKeeper> getGoalKeepers() {
        return goalKeepers;
    }

    public void setGoalKeepers(ArrayList<GoalKeeper> goalKeepers) {
        this.goalKeepers = goalKeepers;
    }

    public void addGoalKeepers(GoalKeeper goalKeepers) {
        this.goalKeepers.add(goalKeepers);
    }

    public ArrayList<Defender> getDefenders() {
        return defenders;
    }

    public void setDefenders(ArrayList<Defender> defenders) {
        this.defenders = defenders;
    }

    public void addDefender(Defender defender) {
        this.defenders.add(defender);
    }

    public ArrayList<Midfielder> getMidfielders() {
        return midfielders;
    }

    public void setMidfielders(ArrayList<Midfielder> midfielders) {
        this.midfielders = midfielders;
    }

    public void addMidfielder(Midfielder midfielder) {
        this.midfielders.add(midfielder);
    }

    public ArrayList<Striker> getStrikers() {
        return strikers;
    }

    public void setStrikers(ArrayList<Striker> strikers) {
        this.strikers = strikers;
    }

    public void addStriker(Striker striker) {
        this.strikers.add(striker);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getGoalRatio() {
        return goalsScored - goalsConceded;
    }

    public void addTeamStats(Old_GameWeekStat gws) {
        if(stats[gws.getGameweek()] == null) {
            stats[gws.getGameweek()] = new TeamStats(gws);
        }
    }

    // Returns all players that played during the game, even if they did not start.
    //TODO: order of collection list??
    public LinkedList<Player> getTeamInGameWeek(int gw) {
        LinkedList<Player> gwTeam = new LinkedList<>();
        gwTeam.addAll(goalKeepers.stream().filter(player -> player.getMinutesPlayed(gw) > 0).collect(Collectors.toList()));
        gwTeam.addAll(defenders.stream().filter(player -> player.getMinutesPlayed(gw) > 0).collect(Collectors.toList()));
        gwTeam.addAll(midfielders.stream().filter(player -> player.getMinutesPlayed(gw) > 0).collect(Collectors.toList()));
        gwTeam.addAll(strikers.stream().filter(player -> player.getMinutesPlayed(gw) > 0).collect(Collectors.toList()));
        return gwTeam;
    }

    private List<Player> wasOnTeam(ArrayList<Player> players, int gw) {
        return players.stream().filter(player -> player.getMinutesPlayed(gw) > 0).collect(Collectors.toList());
    }

    public int totalPointsInGameWeek(int gw) {
        int points = 0;
        points += pointsInGameWeek(goalKeepers, gw);
        points += pointsInGameWeek(defenders, gw);
        points += pointsInGameWeek(midfielders, gw);
        points += pointsInGameWeek(strikers, gw);
        return points;
    }

    private int pointsInGameWeek(ArrayList players, int gw) {
        int points = 0;
        for(Object o : players) {
            Player player = (Player) o;
            points += player.getPoints(gw);
        }
        return points;
    }

    public int totalPointsAtGameweek(int gw) {
        int pts = 0;
        for(TeamStats ts : stats) {
            if(ts != null && ts.gameWeek < gw) {
                pts += ts.getPoints();
            }
        }
        return pts;
    }

    public int totalPoints() {
        return totalPointsAtGameweek(39);
    }

    public int totalMatches() {
        int games = 0;
        for(TeamStats ts : stats) {
            if(ts != null) {
                games++;
                if(ts.isDouble()) games++;
            }
        }
        return games;
    }

    public void showPlayers() {
        System.out.println(getName() + " players:");
        for(GoalKeeper gk : goalKeepers) {
            System.out.println("GK :" + gk.getName() + " (" + Util.sum(gk.getPoints()) + ")");
        }
        for(Defender def : defenders) {
            System.out.println("DEF:" + def.getName() + " (" + Util.sum(def.getPoints()) + ")");
        }
        for(Midfielder mid : midfielders) {
            System.out.println("MID:" + mid.getName() + " (" + Util.sum(mid.getPoints()) + ")");
        }
        for(Striker str : strikers) {
            System.out.println("STR:" + str.getName() + " (" + Util.sum(str.getPoints()) + ")");
        }
    }

    public void showPlayersByGw(int gw) {
        System.out.println(getName() + " players:");
        Collections.sort(goalKeepers);
        Collections.sort(defenders);
        Collections.sort(midfielders);
        Collections.sort(strikers);
        for(GoalKeeper gk : goalKeepers) {
            System.out.println("GK :" + gk.getName() + " (" + Util.sum(gk.getPoints(), gw) + ")");
        }
        for(Defender def : defenders) {
            System.out.println("DEF:" + def.getName() + " (" + Util.sum(def.getPoints(), gw) + ")");
        }
        for(Midfielder mid : midfielders) {
            System.out.println("MID:" + mid.getName() + " (" + Util.sum(mid.getPoints(), gw) + ")");
        }
        for(Striker str : strikers) {
            System.out.println("STR:" + str.getName() + " (" + Util.sum(str.getPoints(), gw) + ")");
        }
    }

    public TeamStats getStats(int gw) {
        return (hasStats(gw))? stats[gw] : null;
    }

    public boolean hasStats(int gw) {
        return stats[gw] != null;
    }

    public Integer totalPointsAllPlayers() {
        int points = 0;
        for(GoalKeeper gk : goalKeepers) {
            points += Util.sum(gk.getPoints());
        }
        for(Defender def : defenders) {
            points += Util.sum(def.getPoints());
        }
        for(Midfielder mid : midfielders) {
            points += Util.sum(mid.getPoints());
        }
        for(Striker str : strikers) {
            points += Util.sum(str.getPoints());
        }
        return points;
    }

    public Match[] getMatches() {
        return matches;
    }

    @Override
    public boolean equals(Object o) {
       return (o instanceof Team) && (this.name.equals(((Team) o).getName()));
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

     public int compareTo(Team o) {
        if (this.totalPoints() < o.totalPoints()) return 1;
        else if (this.totalPoints() > o.totalPoints()) return -1;
        else {
            if (this.getGoalRatio() < o.getGoalRatio()) return 1;
            else if (this.getGoalRatio() > o.getGoalRatio()) return -1;
            else {
                if (this.getGoalsScored() < o.getGoalsScored()) return 1;
                else if (this.getGoalsScored() > o.getGoalsScored()) return -1;
                else {
                    return this.getName().compareTo(o.getName());
                }
            }
        }
    }

    class TeamStats {
        double gameWeek;
        String team;
        String score;
        int homeScore;
        int awayScore;
        String opponent;
        String h_a;
        int points;

        TeamStats doubleGw;

        public TeamStats(double gw, String team, String score, String opponent, String h_a) {
            this.gameWeek = gw;
            this.team = team;
            this.score = score;
            String []s = score.split(" - ");
            this.homeScore = Integer.parseInt(s[0]);
            this.awayScore = Integer.parseInt(s[1]);
            this.opponent = opponent;
            this.h_a = h_a;
            if(homeScore > awayScore) {
                points = 3;
            } else if (homeScore < awayScore){
                points = 0;
            } else {
                points = 1;
            }
        }

        public TeamStats(Old_GameWeekStat gws) {
            this(gws.getGameweek(), gws.getTeam(), gws.getScore(), gws.getOpponent(), gws.getH_A());
        }

        public String toString() {
            String where = (h_a.equals("home"))? " at home" : " away";
            return "GW " + gameWeek + ": " + team +  where + " against " + opponent + ": " + score;
        }

        public void setDoubleGw(TeamStats doubleGw) {
            this.doubleGw = doubleGw;
        }

        public void setDoubleGw(Old_GameWeekStat doubleGw) {
            this.doubleGw = new TeamStats(doubleGw);
        }

        public TeamStats getDoubleGw() {
            return doubleGw;
        }

        public boolean isDouble() {
            return doubleGw != null;
        }

        public int getPoints() {
            return (isDouble())? points + doubleGw.getPoints() : points;
        }
    }
}
