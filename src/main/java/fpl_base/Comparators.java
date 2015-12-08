package fpl_base;

import java.util.Comparator;

public class Comparators {


    public static Comparator<Player> pointComparator = (Player p1, Player p2) -> p2.getTotalPoints() - p1.getTotalPoints();

    public static Comparator<Player> pointsPerMatchComparator = (Player p1, Player p2) -> p2.getTotalPoints() / p2.matchesPlayed() - p1.getTotalPoints() / p1.matchesPlayed();

    public static Comparator<Player> pointsPerMinComparator = (Player p1, Player p2) -> p2.pointsPerMin().compareTo(p1.pointsPerMin());

    public static Comparator<Player> minsPerGoalComparator = (Player p1, Player p2) -> p2.minsPerGoal().compareTo(p1.minsPerGoal());

    public static Comparator<Player> goalsPerMinComparator = (Player p1, Player p2) -> p2.goalsPerMin().compareTo(p1.goalsPerMin());

    public static Comparator<Player> goalsPerMatchComparator = (Player p1, Player p2) -> p2.goalsPerMatch().compareTo(p1.goalsPerMatch());

    public static Comparator<Team> teamPlayerPointsComparator = (Team t1, Team t2) -> t2.totalPointsAllPlayers().compareTo(t1.totalPointsAllPlayers());

    public static Comparator<Team> teamPointComparator = (Team t1, Team t2) -> t2.getPoints() - t1.getPoints();


}
