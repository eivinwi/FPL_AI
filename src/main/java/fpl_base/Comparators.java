package fpl_base;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eivwik on 02.12.15.
 */
public class Comparators {


    public static <Player> Comparator<Player> comparePoints() {
        return (e1, e2) -> 0;
    }

    public static <Player> Comparator<Player> compareAverage() {
        return (e1, e2) -> 0;
    }

    public static <Player> Comparator<Player> compareGamesPlayed() {
        return (e1, e2) -> 0;
    }

    public static <Player> Comparator<Player> compareMinutesPlayed() {
        return (e1, e2) -> 0;
    }


}
