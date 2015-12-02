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

    HashMap<Double, TeamStats> stats;

    private int points;
    private int goalsScored;
    private int goalsConceded;

    public Team(String name) {
        this.name = name;
        goalKeepers = new ArrayList<>();
        defenders = new ArrayList<>();
        midfielders = new ArrayList<>();
        strikers = new ArrayList<>();
        stats = new HashMap<>();
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

    public void addTeamStats(GameWeekStat gws) {
        if(!stats.containsKey(gws.getGameweek())) {
            if(stats.containsKey(gws.getGameweek() - 1.0)) {
                if(gws.getGameweek() % 1 == 0) {
                    stats.put(gws.getGameweek(), new TeamStats(gws, stats.get(gws.getGameweek() - 1.0).totalPoints));
                } else {
                    stats.put(gws.getGameweek(), new TeamStats(gws, stats.get(gws.getGameweek() - 0.5).totalPoints));
                }
            } else {
                stats.put(gws.getGameweek(), new TeamStats(gws, 0));
            }
        }
    }

    // Returns all players that played during the game, even if they did not start.
    //TODO: order of collection list??
    public LinkedList<Player> getTeamInGameWeek(double gw) {
        LinkedList<Player> gwTeam = new LinkedList<>();
        gwTeam.addAll(goalKeepers.stream().filter(player -> player.getStats(gw).getMinutesPlayed() > 0).collect(Collectors.toList()));
        gwTeam.addAll(defenders.stream().filter(player -> player.getStats(gw).getMinutesPlayed() > 0).collect(Collectors.toList()));
        gwTeam.addAll(midfielders.stream().filter(player -> player.getStats(gw).getMinutesPlayed() > 0).collect(Collectors.toList()));
        gwTeam.addAll(strikers.stream().filter(player -> player.getStats(gw).getMinutesPlayed() > 0).collect(Collectors.toList()));
        return gwTeam;
    }

    private List<Player> wasOnTeam(ArrayList<Player> players, double gw) {
        return players.stream().filter(player -> player.getStats(gw).getMinutesPlayed() > 0).collect(Collectors.toList());
    }

    public int totalPointsInGameWeek(double gw) {
        int points = 0;
        points += pointsInGameWeek(goalKeepers, gw);
        points += pointsInGameWeek(defenders, gw);
        points += pointsInGameWeek(midfielders, gw);
        points += pointsInGameWeek(strikers, gw);
        return points;
    }

    private int pointsInGameWeek(ArrayList players, double gw) {
        int points = 0;
        for(Object o : players) {
            Player player = (Player) o;
            points += player.getStats(gw).getPoints();
        }
        return points;
    }

    public int totalPointsAtGameweek(double gw) {
   /*     if(!stats.containsKey(gw)) {
            System.out.println("WARNING: " + getName() + " does not have a GW " + gw);
            return 0;
        }
*/
        int pts = 0;
        int wins = 0, losses = 0, draws = 0;
        for(TeamStats ts : stats.values()) {
            if(ts.gameWeek < gw) {
                pts += ts.points;
                if(ts.points == 3) wins++;
                else if (ts.points == 1) draws++;
                else losses++;
            }
          //  System.out.println("GW " + ts.gameWeek + ", points= " + pts + "          " + ts.points);
        }
     //   System.out.println(wins + ", " + draws + "," + losses);

//        return stats.get(gw).totalPoints;

        return pts;
    }

    public int totalPoints() {
        return totalPointsAtGameweek(38.0);
    }

    public int totalMatches() {
        return stats.size();
    }

    public void showPlayers() {
        System.out.println(getName() + " players:");
        for(GoalKeeper gk : goalKeepers) {
            System.out.println("GK :" + gk.getName() + " (" + gk.getTotalPoints() + ")");
        }
        for(Defender def : defenders) {
            System.out.println("DEF:" + def.getName() + " (" + def.getTotalPoints() + ")");
        }
        for(Midfielder mid : midfielders) {
            System.out.println("MID:" + mid.getName() + " (" + mid.getTotalPoints() + ")");
        }
        for(Striker str : strikers) {
            System.out.println("STR:" + str.getName() + " (" + str.getTotalPoints() + ")");
        }
    }

    public void showPlayersByGw(double gw) {
        System.out.println(getName() + " players:");
        Collections.sort(goalKeepers);
        Collections.sort(defenders);
        Collections.sort(midfielders);
        Collections.sort(strikers);
        for(GoalKeeper gk : goalKeepers) {
            System.out.println("GK :" + gk.getName() + " (" + gk.getTotalPointsAtGw(gw) + ")");
        }
        for(Defender def : defenders) {
            System.out.println("DEF:" + def.getName() + " (" + def.getTotalPointsAtGw(gw) + ")");
        }
        for(Midfielder mid : midfielders) {
            System.out.println("MID:" + mid.getName() + " (" + mid.getTotalPointsAtGw(gw) + ")");
        }
        for(Striker str : strikers) {
            System.out.println("STR:" + str.getName() + " (" + str.getTotalPointsAtGw(gw) + ")");
        }
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
        if (this.totalPoints() > o.totalPoints()) return 1;
        else if (this.totalPoints() < o.totalPoints()) return -1;
        else {
            if (this.getGoalRatio() > o.getGoalRatio()) return 1;
            else if (this.getGoalRatio() < o.getGoalRatio()) return -1;
            else {
                if (this.getGoalsScored() > o.getGoalsScored()) return 1;
                else if (this.getGoalsScored() < o.getGoalsScored()) return -1;
                else {
                    return this.getName().compareTo(o.getName());
                }
            }
        }
    }

    private class TeamStats {
        double gameWeek;
        String team;
        String score;
        int homeScore;
        int awayScore;
        String oponent;
        String h_a;
        int points;
        int totalPoints;


        public TeamStats(double gw, String team, String score, String oponent, String h_a, int pointsPreviously) {
            this.gameWeek = gw;
            this.team = team;
            this.score = score;
            String []s = score.split(" - ");
            this.homeScore = Integer.parseInt(s[0]);
            this.awayScore = Integer.parseInt(s[1]);
            this.oponent = oponent;
            this.h_a = h_a;
            if(homeScore > awayScore) {
                points = 3;
            } else if (homeScore < awayScore){
                points = 0;
            } else {
                points = 1;
            }
            this.totalPoints = pointsPreviously + points;

            if(team.equals("CHE") && points == 0) {
                String where = (h_a.equalsIgnoreCase("home"))? " at home" : " away";
                System.out.print("GW" + gameWeek + "Chelsea " + where + " against " + oponent +  ": " + score + " [" + homeScore + "-" + awayScore);
                System.out.println(". points:" + points + "   total=" + totalPoints);
            }
        }

        public TeamStats(GameWeekStat gws, int pointsPreviously) {
            this(gws.getGameweek(), gws.getTeam(), gws.getScore(), gws.getOpponent(), gws.getH_A(), pointsPreviously);
        }

        public String toString() {
            String where = (h_a.equals("home"))? " at home" : " away";
            return "GW " + gameWeek + ": " + team +  where + " against " + oponent + ": " + score;
        }
    }
}
