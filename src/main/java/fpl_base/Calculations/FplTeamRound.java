package fpl_base.Calculations;

import fpl_base.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Calculates the optimal team for a single FPL round. Takes a base teams plus bank/free transfers as input.
 * This class should be used in conjunction with another class that handles long-term calculations.
 */
public class FplTeamRound {
    private int gw;
    boolean isDouble = false; // fuckin' double gameweeks, ruining everything..
    boolean hasPlayed = false;
    boolean hasBeenCleaned = false;

    private List<GoalKeeper> goalKeepers;
    private List<Defender> defenders;
    private List<Midfielder> midfielders;
    private List<Striker> strikers;

    private int numGk = 1;          // defenders 1, only affected by bench-boost
    private int numDefenders = 3;   // defenders 3
    private int numMidfielders = 4; // defenders 4
    private int numStrikers = 3;    // defenders 3

    FplTeamRound(int gw) {
        this.gw = gw;
        goalKeepers = new ArrayList<>();
        defenders = new ArrayList<>();
        midfielders = new ArrayList<>();
        strikers = new ArrayList<>();
    }

    FplTeamRound(int gw, List<Player> team) {
        this.gw = gw;
        goalKeepers = new ArrayList<>();
        defenders = new ArrayList<>();
        midfielders = new ArrayList<>();
        strikers = new ArrayList<>();
        for(Player p : team) {
            switch(p.type()) {
                case GOALKEEPER:
                    goalKeepers.add((GoalKeeper) p);
                    break;
                case DEFENDER:
                    defenders.add((Defender) p);
                    break;
                case MIDFIELDER:
                    midfielders.add((Midfielder) p);
                    break;
                case STRIKER:
                    strikers.add((Striker) p);
                    break;
                default: break;
            }
        }
    }

    public void setFormation(int def, int mid, int str) {
        if(def + mid + str == 10 &&
                def > 2 && def < 5 &&
                mid > 1 && mid < 6 &&
                str > 0 && str < 4) {
            numDefenders = def;
            numMidfielders = mid;
            numStrikers = str;
        } else if(def == 2) {
            System.err.println("Two defenders can only be set with bench boost.");
        }
        else {
            System.err.format("%d-%d-%d is not a valid setup.", def, mid, str);
        }
    }

    public void enableBenchBoost(boolean b) {
        if(b) {
            numGk = 2;
            numDefenders = 5;
            numMidfielders = 5;
            numStrikers = 3;
        } else {
            numGk = 1;
            numDefenders = 3;
            numMidfielders = 4;
            numStrikers = 3;
        }
    }


    public int getPoints() {
        return 0;/*
        if(!hasPlayed) {
            return 0;
        }
        int points = 0;
        points += goalKeepers.get(0).getPoints(gw);
        for(int i = 0; i < numDefenders; i++) points += defenders.get(i).getPoints(gw);
        for(int i = 0; i < numMidfielders; i++) points += midfielders.get(i).getPoints(gw);
        for(int i = 0; i < numStrikers; i++) points += strikers.get(i).getPoints(gw);
        return points;*/
    }

    /**
     * Calculates the optimal team setup retrospectively.
     * inputs: FPL-options to enable
     * returns: maximum amount of points with the set team in the best possible formation.
     *          alternatively returns 0 if the gameweek has not yet been played.
     */
    public List<Player> getOptimalPoints(boolean benchBoost, boolean allOut, boolean tripleCaptain) {
      /*  List<Player> team = new ArrayList<>();
        //if(!hasPlayed) {
        //    return team;
        //}

        //fill in the best minimum-team (1gk, 2def, 2mid, 1str) = 6players
        Comparator<Player> pointThisWeekComp = (Player p1, Player p2) -> p2.getPoints(gw) - p1.getPoints(gw);
        List<Player> players = new ArrayList<>();
        players.addAll(goalKeepers);
        players.addAll(defenders);
        players.addAll(midfielders);
        players.addAll(strikers);
        Collections.sort(players, pointThisWeekComp);

        int gks = 0, defs = 0, mids = 0, strs = 0;
        int teamSize = 11;
        int[] min;
        if(benchBoost) {
            teamSize = 15;
            min = new int[]{2, 5, 5, 3};
        } else if(allOut) {
            min = new int[]{1, 2, 2, 1};
        } else {
            min = new int[]{1, 3, 2, 1};
        }

        while(team.size() < teamSize) {
            Player p = players.remove(0);
            switch(p.type()) {
                case GOALKEEPER:
                    if(gks == 0 || benchBoost) {
                        team.add(p);
                        gks++;
                    }
                    break;
                case DEFENDER:
                    if((team.size() < 10) || (mids >= min[2] && strs >= min[3]) || benchBoost) {
                        team.add(p);
                        defs++;
                    }
                    break;
                case MIDFIELDER:
                    if((team.size() < 10) || (defs >= min[1] && strs >= min[3]) || benchBoost) {
                        team.add(p);
                        mids++;
                    }
                    break;
                case STRIKER:
                    if((team.size() < 10) || (defs >= min[1] && mids >= min[2]) || benchBoost) {
                        team.add(p);
                        strs++;
                    }
                    break;
                default:
                    break;
            }

        }

        return team;*/
        return null;
    }


    private class Permutation {

    }
}
