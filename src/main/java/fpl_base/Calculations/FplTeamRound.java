package fpl_base.Calculations;

import fpl_base.Defender;
import fpl_base.GoalKeeper;
import fpl_base.Midfielder;
import fpl_base.Striker;
import fpl_base.Util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by eivwik on 16.12.15.
 */
public class FplTeamRound {
    int gw;
    boolean isDouble = false; // fuckin' double gameweeks, ruining everything..
    boolean hasPlayed = false;
    boolean hasBeenCleaned = false;

    List<GoalKeeper> gk;
    List<Defender> def;
    List<Midfielder> mid;
    List<Striker> str;

    int numGk = 1;          // def 1, only affected by bench-boost
    int numDefenders = 3;   // def 3
    int numMidfielders = 4; // def 4
    int numStrikers = 3;    // def 3

    FplTeamRound(int gw) {
        this.gw = gw;
        gk = new ArrayList<>();
        def = new ArrayList<>();
        mid = new ArrayList<>();
        str = new ArrayList<>();
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
        if(!hasPlayed) {
            return 0;
        }
        int points = 0;
        points += gk.get(0).getPoints(gw);
        for(int i = 0; i < numDefenders; i++) points += def.get(i).getPoints(gw);
        for(int i = 0; i < numMidfielders; i++) points += mid.get(i).getPoints(gw);
        for(int i = 0; i < numStrikers; i++) points += str.get(i).getPoints(gw);
        return points;
    }

    public int getOptimalPoints(boolean benchBoost, boolean allOut, boolean tripleCaptain) {
        if(!hasPlayed) {
            return 0;
        }

        //TODO
        return -1;
    }



    private class Permutation {

    }
}
