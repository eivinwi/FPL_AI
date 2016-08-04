package fpl_base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eivind on 27.03.2016.
 */
public class Round {
    public enum State {TO_COME, STARTED, IN_PROGRESS, COMPLETED }

    private List<Match> matches;

    private State state = State.TO_COME;

    // true if at least 1 teams has a dgw
    private boolean dgw = false;
    // true if at least 1 teams has a blank
    private boolean blank = false;

    Round() {
        matches = new ArrayList<>();
    }

    Round(List<Match> matches) {
        this.matches = matches;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() { return state; }

    //TODO
    public List<Player> dreamTeam() {
        return new ArrayList<>();
    }
}
