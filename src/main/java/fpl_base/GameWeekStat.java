package fpl_base;

/*
 * NOTE: not all methods are optimized for double gameweeks (or working at all, really..)
 */
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
    private int penaltiesMissed;
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
    private int gameweek;
    private String position;
    private String difficultyRank;
    private String difficultyDesc;
    private int PID;
    private double ownedPercent;
    private String date;
    private String kickoffTime;
    private double seasonStartPrice;
    private double seasonEndprice;

    GameWeekStat doubleGw;

    public GameWeekStat(String[] s) {
        if(s.length < 30) { //Todo: check
            System.out.println("Line array too short");
        } else if(s[20].contains(".")) {
            System.out.println("Double gameweek entered as single.");
        }
        else {
            this.name = s[0];
            this.minutesPlayed = Integer.parseInt(s[1]);
            this.goalsScored = Integer.parseInt(s[2]);
            this.assists = Integer.parseInt(s[3]);
            this.cleanSheet = Integer.parseInt(s[4]);
            this.goalsConceded = Integer.parseInt(s[5]);
            this.ownGoals = Integer.parseInt(s[6]);
            this.penaltiesSaved = Integer.parseInt(s[7]);
            this.penaltiesMissed = Integer.parseInt(s[8]);
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
            this.gameweek = Integer.parseInt(s[20]); //s[20].contains(".")? Double.parseDouble(s[20]) TODO: må fikses før!
            this.position = s[21];
            this.difficultyRank = s[22];
            this.difficultyDesc = s[23];
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
        this.penaltiesMissed = 0;
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
        this.difficultyDesc = "NaN";
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
        return (doubleGw == null)? minutesPlayed : minutesPlayed + doubleGw.getMinutesPlayed();
    }

    public int getGoalsScored() {
        return (doubleGw == null)? goalsScored : goalsScored + doubleGw.getGoalsScored();
    }

    public int getAssists() {
        return (doubleGw == null)? assists : assists + doubleGw.getAssists();
    }

    public int getCleanSheet() {
        return (doubleGw == null)? cleanSheet : cleanSheet + doubleGw.getCleanSheet();
    }

    public int getGoalsConceded() {
        return (doubleGw == null)? goalsConceded : goalsConceded + doubleGw.getGoalsConceded();
    }

    public int getOwnGoals() {
        return (doubleGw == null)? ownGoals : ownGoals + doubleGw.getOwnGoals();
    }

    public int getPenaltiesSaved() {
        return (doubleGw == null)? penaltiesSaved : penaltiesSaved + doubleGw.getPenaltiesSaved();
    }

    public int getPenaltiesMissed() {
        return (doubleGw == null)? penaltiesMissed : penaltiesMissed + doubleGw.getPenaltiesMissed();
    }

    public int getYellowCards() {
        return (doubleGw == null)? yellowCards : yellowCards + doubleGw.getYellowCards();
    }

    public int getRedCards() {
        return (doubleGw == null)? redCards : redCards + doubleGw.getRedCards();
    }

    public int getSaves() {
        return (doubleGw == null)? saves : saves + doubleGw.getSaves();
    }

    public int getBonus() {
        return (doubleGw == null)? bonus : bonus + doubleGw.getBonus();
    }

    public int getEA_SPORTS_PPI() {
        return (doubleGw == null)? EA_SPORTS_PPI : EA_SPORTS_PPI + doubleGw.getEA_SPORTS_PPI();
    }

    public int getBonusSystemScoring() {
        return (doubleGw == null)? bonusSystemScoring : bonusSystemScoring + doubleGw.getBonusSystemScoring();
    }

    public int getPoints() {
        return (doubleGw == null)? points : points + doubleGw.getPoints();
    }

    public String getTeam() {
        return team;
    }

    public String getScore() {
        return (doubleGw == null)? score : score + " and " + doubleGw.getScore();
    }

    public String getOpponent() {
        return (doubleGw == null) ? opponent : opponent + " and " + doubleGw.getOpponent();
    }

    public String getH_A() {
        return (doubleGw == null)? H_A : H_A + " and " + doubleGw.getH_A();
    }

    public int getGameweek() {
        return gameweek;
    }

    public String getPosition() {
        return position;
    }

    public String getDifficultyRank() {
        return (doubleGw == null)? difficultyRank : difficultyRank + " and " + doubleGw.getDifficultyRank();
    }

    public String getDifficultyDesc() {
        return (doubleGw == null)? difficultyDesc : difficultyDesc + " and " + doubleGw.getDifficultyDesc();
    }

    public int getPID() {
        return PID;
    }

    public double getOwnedPercent() {
        return ownedPercent;
    }

    public String getDate() {
        return (doubleGw == null)? date : date + " and " + doubleGw.getDate();
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

    public void setDoubleGw(GameWeekStat doubleGw) {
        this.doubleGw = doubleGw;
    }

    public GameWeekStat getDoubleGw() {
        return doubleGw;
    }

    public boolean isDouble() {
        return doubleGw != null;
    }

    public void print() {
        System.out.println(name + ", GW" + gameweek + ": " + score + " "   + H_A + " against " + opponent + ". Points: " + points + " (" + bonus + " bonus)");
    }

    public void printAdvanced() {
        //TODO
    }
}