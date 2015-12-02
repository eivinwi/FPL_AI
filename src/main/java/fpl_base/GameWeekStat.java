package fpl_base;

@SuppressWarnings("unused")
public class GameWeekStat {
    private String name;
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
    private int EA_SPORTS_PPI;
    private int bonusSystemScoring;
    private int points;

    private String team;
    private String score;
    private String opponent;
    private String H_A;
    private double gameweek;
    private String position;
    private String difficultyRank;
    private String getDifficultyDesc;
    private int PID;
    private double ownedPercent;
    private String date;
    private String kickoffTime;
    private double seasonStartPrice;
    private double seasonEndprice;

    public GameWeekStat(String[] s) {
        if(s.length < 30) { //Todo: check
            System.out.println("Line array too short");
        } else {
            this.name = s[0];
            this.minutesPlayed = Integer.parseInt(s[1]);
            this.goalsScored = Integer.parseInt(s[2]);
            this.assists = Integer.parseInt(s[3]);
            this.cleanSheet = Integer.parseInt(s[4]);
            this.goalsConceded = Integer.parseInt(s[5]);
            this.ownGoals = Integer.parseInt(s[6]);
            this.penaltiesSaved = Integer.parseInt(s[7]);
            this.pentaltiesMissed = Integer.parseInt(s[8]);
            this.yellowCards = Integer.parseInt(s[9]);
            this.redCards = Integer.parseInt(s[10]);
            this.saves = Integer.parseInt(s[11]);
            this.bonus = Integer.parseInt(s[12]);
            this.EA_SPORTS_PPI = Integer.parseInt(s[13]);
            this.bonusSystemScoring = Integer.parseInt(s[14]);
            this.points = Integer.parseInt(s[15]);
            this.team = s[16];
            this.score = s[17];
            this.opponent = s[18];
            this.H_A = s[19];
            this.gameweek = s[20].contains(".")? Double.parseDouble(s[20]) : Integer.parseInt(s[20]);
            this.position = s[21];
            this.difficultyRank = s[22];
            this.getDifficultyDesc = s[23];
            this.PID = Integer.parseInt(s[24]);
            this.ownedPercent = s[25].contains(".")? Double.parseDouble(s[25]) : Integer.parseInt(s[25]);
            this.date = s[26];
            this.kickoffTime = s[27];
            this.seasonStartPrice = s[28].contains(".")? Double.parseDouble(s[28]) : Integer.parseInt(s[28]);
            this.seasonEndprice = s[29].contains(".")? Double.parseDouble(s[29]) : Integer.parseInt(s[29]);
        }
    }

    public GameWeekStat() {
        this.name = "";
        this.minutesPlayed = 0;
        this.goalsScored = 0;
        this.assists = 0;
        this.cleanSheet = 0;
        this.goalsConceded = 0;
        this.ownGoals = 0;
        this.penaltiesSaved = 0;
        this.pentaltiesMissed = 0;
        this.yellowCards = 0;
        this.redCards = 0;
        this.saves = 0;
        this.bonus = 0;
        this.EA_SPORTS_PPI = 0;
        this.bonusSystemScoring = 0;
        this.points = 0;
        this.team = "NaN";
        this.score = "NaN";
        this.opponent = "NaN";
        this.H_A = "NaN";
        this.gameweek = 0;
        this.position = "NaN";
        this.difficultyRank = "NaN";
        this.getDifficultyDesc = "NaN";
        this.PID = 0;
        this.ownedPercent = 0.0;
        this.date = "NaN";
        this.kickoffTime = "NaN";
        this.seasonStartPrice = 0.0;
        this.seasonEndprice = 0.0;
    }

    public String getName() {
        return name;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getAssists() {
        return assists;
    }

    public int getCleanSheet() {
        return cleanSheet;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getOwnGoals() {
        return ownGoals;
    }

    public int getPenaltiesSaved() {
        return penaltiesSaved;
    }

    public int getPentaltiesMissed() {
        return pentaltiesMissed;
    }

    public int getYellowCards() {
        return yellowCards;
    }

    public int getRedCards() {
        return redCards;
    }

    public int getSaves() {
        return saves;
    }

    public int getBonus() {
        return bonus;
    }

    public int getEA_SPORTS_PPI() {
        return EA_SPORTS_PPI;
    }

    public int getBonusSystemScoring() {
        return bonusSystemScoring;
    }

    public int getPoints() {
        return points;
    }

    public String getTeam() {
        return team;
    }

    public String getScore() {
        return score;
    }

    public String getOpponent() {
        return opponent;
    }

    public String getH_A() {
        return H_A;
    }

    public double getGameweek() {
        return gameweek;
    }

    public String getPosition() {
        return position;
    }

    public String getDifficultyRank() {
        return difficultyRank;
    }

    public String getGetDifficultyDesc() {
        return getDifficultyDesc;
    }

    public int getPID() {
        return PID;
    }

    public double getOwnedPercent() {
        return ownedPercent;
    }

    public String getDate() {
        return date;
    }

    public String getKickoffTime() {
        return kickoffTime;
    }

    public double getSeasonStartPrice() {
        return seasonStartPrice;
    }

    public double getSeasonEndprice() {
        return seasonEndprice;
    }

    public void print() {
        System.out.println(name + ", GW" + gameweek + ": " + score + " "   + H_A + " against " + opponent + ". Points: " + points + " (" + bonus + " bonus)");
    }

    public void printAdvanced() {
        //TODO
    }
}