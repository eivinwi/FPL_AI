package fpl_base;

public class MatchStats {
    private String name; //player


    private int points;
    private int minutesPlayed;
    private int goalsScored;
    private int assists;
    private int cleanSheet;
    private int goalsConceded;
    private int ownGoals;
    private int penaltiesSaved;
    private int pentaltiesMissed;
    private int yellowCards;
    private int redCards;
    private int saves;
    private int bonus;
    private int bonusSystemScoring;
    private int EA_SPORTS_PPI;

    public MatchStats(int points, int minutesPlayed, int goalsScored, int assists, int cleanSheet,
                      int goalsConceded, int ownGoals, int penaltiesSaved, int pentaltiesMissed, int yellowCards,
                      int redCards, int saves, int bonus, int bonusSystemScoring, int EA_SPORTS_PPI) {
        this.points = points;
        this.minutesPlayed = minutesPlayed;
        this.goalsScored = goalsScored;
        this.assists = assists;
        this.cleanSheet = cleanSheet;
        this.goalsConceded = goalsConceded;
        this.ownGoals = ownGoals;
        this.penaltiesSaved = penaltiesSaved;
        this.pentaltiesMissed = pentaltiesMissed;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.saves = saves;
        this.bonus = bonus;
        this.bonusSystemScoring = bonusSystemScoring;
        this.EA_SPORTS_PPI = EA_SPORTS_PPI;
    }

    public MatchStats() {
        this(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
    }
    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(int cleanSheet) {
        this.cleanSheet = cleanSheet;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public void setGoalsConceded(int goalsConceded) {
        this.goalsConceded = goalsConceded;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public void setOwnGoals(int ownGoals) {
        this.ownGoals = ownGoals;
    }

    public int getPenaltiesSaved() {
        return penaltiesSaved;
    }

    public void setPenaltiesSaved(int penaltiesSaved) {
        this.penaltiesSaved = penaltiesSaved;
    }

    public int getPentaltiesMissed() {
        return pentaltiesMissed;
    }

    public void setPentaltiesMissed(int pentaltiesMissed) {
        this.pentaltiesMissed = pentaltiesMissed;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public void setYellowCards(int yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public void setRedCards(int redCards) {
        this.redCards = redCards;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        this.saves = saves;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonusSystemScoring() {
        return bonusSystemScoring;
    }

    public void setBonusSystemScoring(int bonusSystemScoring) {
        this.bonusSystemScoring = bonusSystemScoring;
    }

    public int getEA_SPORTS_PPI() {
        return EA_SPORTS_PPI;
    }

    public void setEA_SPORTS_PPI(int EA_SPORTS_PPI) {
        this.EA_SPORTS_PPI = EA_SPORTS_PPI;
    }
}
