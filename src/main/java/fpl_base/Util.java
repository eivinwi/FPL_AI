package fpl_base;

import java.util.Comparator;

public class Util {


    public static int sum(int[] array, int gw) {
        int sum = 0;
        for(int i = 1; i < gw; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static int sum(int[] array) {
        return sum(array, 39);
    }

    public static Double avg(int[] a1, int[] a2, int gw) {
        return ((double) sum(a1, gw) / (double) sum(a2, gw));
    }

    public static Double avg(int[] a1, int[] a2) {
        return avg(a1, a2, 39);
    }




    public static Comparator<Player> pointComparator = (Player p1, Player p2) -> sum(p2.getPoints()) - sum(p1.getPoints());

    public static Comparator<Player> pointsPerMatchComparator = (Player p1, Player p2) ->
            sum(p2.getPoints()) / p2.matchesPlayed() - sum(p1.getPoints()) / p1.matchesPlayed();

    public static Comparator<Player> pointsPerMinComparator = (Player p1, Player p2) ->
            avg(p2.getPoints(), p2.getMinutesPlayed()).compareTo( avg(p2.getPoints(), p2.getMinutesPlayed()));

    public static Comparator<Player> minsPerPointComparator = (Player p1, Player p2) ->
            avg(p2.getMinutesPlayed(), p2.getPoints()).compareTo( avg(p2.getMinutesPlayed(), p2.getPoints()));

    public static Comparator<Player> goalsPerMatchComparator = (Player p1, Player p2) ->
            sum(p2.getGoals()) / p2.matchesPlayed() - sum(p1.getGoals()) / p1.matchesPlayed();

    public static Comparator<Player> matchesPerGoalComparator = (Player p1, Player p2) ->
            p2.matchesPlayed() / sum(p2.getGoals()) - p1.matchesPlayed() / sum(p1.getGoals());

    public static Comparator<Player> goalsPerMinComparator = (Player p1, Player p2) ->
            avg(p2.getGoals(), p2.getMinutesPlayed()).compareTo( avg(p2.getGoals(), p2.getMinutesPlayed()));

    public static Comparator<Player> minsPerGoalComparator = (Player p1, Player p2) ->
            avg(p2.getMinutesPlayed(), p2.getGoals()).compareTo( avg(p2.getMinutesPlayed(), p2.getGoals()));

    public static Comparator<Player> assistsPerMinComparator = (Player p1, Player p2) ->
            avg(p2.getAssists(), p2.getMinutesPlayed()).compareTo( avg(p2.getAssists(), p2.getMinutesPlayed()));

    public static Comparator<Player> minsPerAssistComparator = (Player p1, Player p2) ->
            avg(p2.getMinutesPlayed(), p2.getAssists()).compareTo( avg(p2.getMinutesPlayed(), p2.getAssists()));

    public static Comparator<Team> teamPlayerPointsComparator = (Team t1, Team t2) ->
            t2.totalPointsAllPlayers().compareTo(t1.totalPointsAllPlayers());

    public static Comparator<Team> teamPointComparator = (Team t1, Team t2) ->
            t2.getPoints() - t1.getPoints();


}
