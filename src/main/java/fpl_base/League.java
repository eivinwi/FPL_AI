package fpl_base;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by Eivind on 08.11.2015.
 */
public class League {
    //TODO: redo list implementation
    private TreeSet<Team> teams;
    //private SortedList<Team> teams;

    public League() {
        //teams = new SortedList<Team>();
        teams = new TreeSet<Team>();
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

    public TreeSet<Team> getTeams() {
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


    public void showTeams() {
        System.out.println("Barclays Premier fpl_base.League - teams:");
        for(Team t : teams) {
            System.out.println(t.getName() + ":  " + t.getPoints());
        }
    }

    public void showTable(double gw) {
        System.out.println("Barclays Premier fpl_base.League - teams:");
        for(Team t : teams) {
            System.out.println(t.getName() + ":  " + t.totalPointsAtGameweek(gw) + "  (" + t.totalMatches() + ")");
        }
    }
}