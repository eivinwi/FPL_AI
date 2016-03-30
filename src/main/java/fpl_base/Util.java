package fpl_base;

import java.util.Comparator;
import fpl_base.Main;
import org.springframework.beans.factory.annotation.Autowired;

public class Util {
    public enum PlayerType {GOALKEEPER, DEFENDER, MIDFIELDER, STRIKER, NONE}
    public static final int CURRENT_SEASON = 2015;

    @Autowired
    private League league;

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

    public Match getMatch(String home, String away) {
        Team h = league.getTeam(home);
        for(Match m : h.getMatches()) {
            if(m.getAway().getName().equals(h.getName())) {
                return m;
            }
        }
        return null;
    }

    public Match getMatch(Team home, Team away) {
        return getMatch(home.getName(), away.getName());
    }
/*

    public static Comparator<Player> pointComparator = (Player p1, Player p2) ->
            sum(p2.currentSeason().getPoints()) - sum(p1.currentSeason().getPoints());

    public static Comparator<Player> pointsPerMatchComparator = (Player p1, Player p2) ->
            sum(p2.currentSeason().getPoints()) / p2.currentSeason().matchesPlayed()
                    - sum(p1.currentSeason().getPoints()) / p1.currentSeason().matchesPlayed();

    public static Comparator<Player> pointsPerMinComparator = (Player p1, Player p2) ->
            avg(p2.currentSeason().getPoints(), p2.currentSeason().getMinutesPlayed()).compareTo( avg(p2.currentSeason().getPoints(), p2.currentSeason().getMinutesPlayed()));

    public static Comparator<Player> minsPerPointComparator = (Player p1, Player p2) ->
            avg(p2.currentSeason().getMinutesPlayed(), p2.currentSeason().getPoints()).compareTo( avg(p2.currentSeason().getMinutesPlayed(), p2.currentSeason().getPoints()));

    public static Comparator<Player> goalsPerMatchComparator = (Player p1, Player p2) ->
            sum(p2.currentSeason().getGoals()) / p2.currentSeason().matchesPlayed() -
                    sum(p1.currentSeason().getGoals()) / p1.currentSeason().matchesPlayed();

    public static Comparator<Player> matchesPerGoalComparator = (Player p1, Player p2) ->
            p2.currentSeason().matchesPlayed() / sum(p2.currentSeason().getGoals()) -
                    p1.currentSeason().matchesPlayed() / sum(p1.currentSeason().getGoals());

    public static Comparator<Player> goalsPerMinComparator = (Player p1, Player p2) ->
            avg(p2.currentSeason().getGoals(),
                    p2.currentSeason().getMinutesPlayed()).compareTo( avg(p2.currentSeason().getGoals(), p2.currentSeason().getMinutesPlayed()));

    public static Comparator<Player> minsPerGoalComparator = (Player p1, Player p2) ->
            avg(p2.currentSeason().getMinutesPlayed(), p2.currentSeason().getGoals()).compareTo( avg(p2.currentSeason().getMinutesPlayed(), p2.currentSeason().getGoals()));

    public static Comparator<Player> assistsPerMinComparator = (Player p1, Player p2) ->
            avg(p2.currentSeason().getAssists(), p2.currentSeason().getMinutesPlayed()).compareTo( avg(p2.currentSeason().getAssists(), p2.currentSeason().getMinutesPlayed()));

    public static Comparator<Player> minsPerAssistComparator = (Player p1, Player p2) ->
            avg(p2.currentSeason().getMinutesPlayed(), p2.currentSeason().getAssists()).compareTo( avg(p2.currentSeason().getMinutesPlayed(), p2.currentSeason().getAssists()));

    public static Comparator<Team> teamPlayerPointsComparator = (Team t1, Team t2) ->
            t2.totalPointsAllPlayers().compareTo(t1.totalPointsAllPlayers());

    public static Comparator<Team> teamPointComparator = (Team t1, Team t2) ->
            t2.getPoints() - t1.getPoints();

*/
}
