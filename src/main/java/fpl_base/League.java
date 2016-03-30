package fpl_base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

import static fpl_base.Util.*;

@SuppressWarnings({"unused", "WeakerAccess"})
@Component
public class League {
    //TODO: redo list implementation
    private LinkedList<Team> teams = new LinkedList<>();

    //private SortedList<Team> teams;
    private PlayerPool players;

    @Autowired
    public League(PlayerPool players) {
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

    public List sortAndCompare(LinkedList list, int n, Comparator comparator) {
        Collections.sort(list, comparator);
        return list.subList(0, (n > 0)? n : list.size());
    }
/*
    public List top(LinkedList list, int n) {
        return sortAndCompare(list, n, pointComparator);
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

    public List pointsPerMatch(LinkedList list, int n) {
        return sortAndCompare(list, n, pointsPerMatchComparator);
    }

    public List pointsPerMin(LinkedList list, int n) {
        return sortAndCompare(list, n, pointsPerMinComparator);
    }

    public List goalsPerMin(LinkedList list, int n) {
        return sortAndCompare(list, n, goalsPerMinComparator);
    }

    public List minsPerGoal(LinkedList list, int n) {
        return sortAndCompare(list, n, minsPerGoalComparator);
    }

    public List goalsPerMatch(LinkedList list, int n) {
        return sortAndCompare(list, n, goalsPerMatchComparator);
    }


    public List<Team> totalPointsAllTeams() {
        List<Team> t = teams;
        Collections.sort(t, teamPlayerPointsComparator);
        return t;
    }

    public List<Team> table() {
        List<Team> t = teams;
        Collections.sort(teams, teamPointComparator);
        return t;
    }*/

    public void showTeams() {
        System.out.println("Barclays Premier fpl_base.League - teams:");
        for(Team t : teams) {
            System.out.println(t.getName() + ":  " + t.getPoints());
        }
    }
/*

    public void showTable(int gw) {
        System.out.println("Barclays Premier fpl_base.League - teams:");
        for(Team t : table()) {
            System.out.println(t.getName() + ":  " + t.totalPointsAtGameweek(gw) + "  (" + t.totalMatches() + ")");
        }
    }*/
}