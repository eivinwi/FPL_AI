package fpl_base;

import java.lang.reflect.Array;
import java.util.*;

@SuppressWarnings("unused")
public class League {
    //TODO: redo list implementation
    private LinkedList<Team> teams;
    PlayerPool players;
    //private SortedList<Team> teams;

    public League(PlayerPool players) {
        //teams = new SortedList<Team>();
        //teams = new TreeSet<>();
        this.players = players;
        teams = new LinkedList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public boolean hasTeam(String name) {
        for(Team team : teams) {
            if(team.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Team getTeam(String name) {
        for(Team team : teams) {
            if(team.getName().equals(name)) {
                return team;
            }
        }
        return null;
    }

    public LinkedList<Team> getTeams() {
        Collections.sort(teams);
        return teams;
    }

    public ArrayList<Team> getTeamsAlphabetically() {
        ArrayList<Team> listOfTeams = new ArrayList<>(teams);
        Collections.sort(listOfTeams,
                new Comparator<Object>() {
                    public int compare(Object o1, Object o2) {
                        Team t1 = (Team) o1;
                        Team t2 = (Team) o2;
                        return t1.getName().compareTo(t2.getName());
                    }
                });
        return listOfTeams;
    }

    public ArrayList<Team> getTeamsByPoints() {
        ArrayList<Team> listOfTeams = new ArrayList<>(teams);
        Collections.sort(listOfTeams,
                new Comparator<Object>() {
                    public int compare(Object o1, Object o2) {
                        Team t1 = (Team) o1;
                        Team t2 = (Team) o2;
                        return t1.compareTo(t2);
                    }
                });
        return listOfTeams;
    }

    public List<GoalKeeper> topGk(int n) {
        return top(players.getGoalKeepers(), n);
    }

    public List<Defender> topDef(int n) {
        return top(players.getDefenders(), n);
    }

    public List<Midfielder> topMid(int n) {
        return top(players.getMidfielders(), n);
    }

    public List<Striker> topStr(int n) {
        return top(players.getStrikers(), n);
    }

    public List top(LinkedList list, int n) {
        if(n < 1) {
            n = list.size();
        }
        Comparator<Player> pointComparator = (Player p1, Player p2) -> (int) (p2.getTotalPoints() - p1.getTotalPoints());
        Collections.sort(list, pointComparator);
        return list.subList(0, n);
    }

    public List topAverage(LinkedList list, int n) {
        if(n < 1) {
            n = list.size();
        }
        Comparator<Player> pointComparator = (Player p1, Player p2) ->
                (int) (p2.getTotalPoints()/p2.matchesPlayed() - p1.getTotalPoints()/p1.matchesPlayed());
        Collections.sort(list, pointComparator);
        return list.subList(0, n);
    }

    public List pointsPerMin(LinkedList list, int n) {
        if(n < 1) {
            n = list.size();
        }
        Comparator<Player> pointComparator = (Player p1, Player p2) ->
                p2.pointsPerMin().compareTo(p1.pointsPerMin());
        Collections.sort(list, pointComparator);
        return list.subList(0, n);
    }

    public List pointsPerMatch(LinkedList list, int n) {
        if(n < 1) {
            n = list.size();
        }
        Comparator<Player> pointComparator = (Player p1, Player p2) ->
                p2.pointsPerMatch().compareTo(p1.pointsPerMatch());
        Collections.sort(list, pointComparator);
        return list.subList(0, n);
    }

    public void showTeams() {
        System.out.println("Barclays Premier fpl_base.League - teams:");
        for(Team t : teams) {
            System.out.println(t.getName() + ":  " + t.getPoints());
        }
    }

    public void showTable(int gw) {
        System.out.println("Barclays Premier fpl_base.League - teams:");
        for(Team t : teams) {
            System.out.println(t.getName() + ":  " + t.totalPointsAtGameweek(gw) + "  (" + t.totalMatches() + ")");
        }
    }
}