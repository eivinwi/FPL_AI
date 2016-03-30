package fpl_base;

@SuppressWarnings("unused")
public class GameWeek {

    // Match
    private boolean played = false;
    private String opponent = "";
    private boolean atHome = false;
    private int difficultyRank = 0;
    private String difficultyDesc = "Just incredibly easy. No opposition at all. I mean, literally...";
    private int PID = 0;
    private String position; //TODO: necessary?
    private String date = "";
    private String kickoffTime = "";

    // FPL
    private double price = 0.0;
    private double ownedPercent = 0.0;
    private int points = 0;
    private double seasonStartPrice = 0.0;
    private double seasonEndprice = 0.0;

    // FPL Points
    private int minutesPlayed = 0;
    private int goals = 0;
    private int assists = 0;
    private int cleanSheet = 0;
    private int goalsConceded = 0;
    private int ownGoals = 0;
    private int penaltiesSaved = 0;
    private int penaltiesMissed = 0;
    private int yellowCards = 0;
    private int redCards = 0;
    private int saves = 0;
    private int bonus = 0;
    private int bonusSystemScoring = 0;
    private int EA_SPORTS_PPI = 0;


    public GameWeek(boolean played, String opponent, boolean atHome, int difficultyRank, String difficultyDesc, int PID,
                    String position, String date, String kickoffTime, double price, double ownedPercent, int points,
                    double seasonStartPrice, double seasonEndprice, int minutesPlayed, int goals, int assists,
                    int cleanSheet, int goalsConceded, int ownGoals, int penaltiesSaved, int penaltiesMissed,
                    int yellowCards, int redCards, int saves, int bonus, int bonusSystemScoring, int EA_SPORTS_PPI) {
        this.played = played;
        this.opponent = opponent;
        this.atHome = atHome;
        this.difficultyRank = difficultyRank;
        this.difficultyDesc = difficultyDesc;
        this.PID = PID;
        this.position = position;
        this.date = date;
        this.kickoffTime = kickoffTime;
        this.price = price;
        this.ownedPercent = ownedPercent;
        this.points = points;
        this.seasonStartPrice = seasonStartPrice;
        this.seasonEndprice = seasonEndprice;
        this.minutesPlayed = minutesPlayed;
        this.goals = goals;
        this.assists = assists;
        this.cleanSheet = cleanSheet;
        this.goalsConceded = goalsConceded;
        this.ownGoals = ownGoals;
        this.penaltiesSaved = penaltiesSaved;
        this.penaltiesMissed = penaltiesMissed;
        this.yellowCards = yellowCards;
        this.redCards = redCards;
        this.saves = saves;
        this.bonus = bonus;
        this.bonusSystemScoring = bonusSystemScoring;
        this.EA_SPORTS_PPI = EA_SPORTS_PPI;
    }

    public GameWeek(String []stats) {
        setStats(stats);
    }

    public void setStats(String[] s) {
        if(s.length < 30) { //Todo: check
            System.out.println("Line array too short");
        } else if(s[20].contains(".")) {
            System.out.println("Double gameweek entered as single.");
        }
        int gw = Integer.parseInt(s[20]);

        if(played) {
            System.out.println("Attempting to re-add gameweek stats.");
        }
        else {
            minutesPlayed = Integer.parseInt(s[1]);
            goals = Integer.parseInt(s[2]);
            assists = Integer.parseInt(s[3]);
            cleanSheet = Integer.parseInt(s[4]);
            goalsConceded = Integer.parseInt(s[5]);
            ownGoals = Integer.parseInt(s[6]);
            penaltiesSaved = Integer.parseInt(s[7]);
            penaltiesMissed = Integer.parseInt(s[8]);
            yellowCards = Integer.parseInt(s[9]);
            redCards = Integer.parseInt(s[10]);
            saves = Integer.parseInt(s[11]);
            bonus = Integer.parseInt(s[12]);
            EA_SPORTS_PPI = Integer.parseInt(s[13]);
            bonusSystemScoring = Integer.parseInt(s[14]);
            points = Integer.parseInt(s[15]);

            //team = s[16]; //TODO: people can change teams internally in PL!!
            //score = s[17];

            opponent = s[18];
            atHome = s[19].equalsIgnoreCase("home");
            position = s[21];
            difficultyRank = Integer.parseInt(s[22]);
            difficultyDesc = s[23];
            PID = Integer.parseInt(s[24]);
            ownedPercent = s[25].contains(".")? Double.parseDouble(s[25]) : Integer.parseInt(s[25]);
            date = s[26];
            kickoffTime = s[27];
            seasonStartPrice = s[28].contains(".")? Double.parseDouble(s[28]) : Integer.parseInt(s[28]);
            seasonEndprice = s[29].contains(".")? Double.parseDouble(s[29]) : Integer.parseInt(s[29]);
        }
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public boolean isAtHome() {
        return atHome;
    }

    public void setAtHome(boolean atHome) {
        this.atHome = atHome;
    }

    public int getDifficultyRank() {
        return difficultyRank;
    }

    public void setDifficultyRank(int difficultyRank) {
        this.difficultyRank = difficultyRank;
    }

    public String getDifficultyDesc() {
        return difficultyDesc;
    }

    public void setDifficultyDesc(String difficultyDesc) {
        this.difficultyDesc = difficultyDesc;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKickoffTime() {
        return kickoffTime;
    }

    public void setKickoffTime(String kickoffTime) {
        this.kickoffTime = kickoffTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getOwnedPercent() {
        return ownedPercent;
    }

    public void setOwnedPercent(double ownedPercent) {
        this.ownedPercent = ownedPercent;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public double getSeasonStartPrice() {
        return seasonStartPrice;
    }

    public void setSeasonStartPrice(double seasonStartPrice) {
        this.seasonStartPrice = seasonStartPrice;
    }

    public double getSeasonEndprice() {
        return seasonEndprice;
    }

    public void setSeasonEndprice(double seasonEndprice) {
        this.seasonEndprice = seasonEndprice;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
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

    public int getPenaltiesMissed() {
        return penaltiesMissed;
    }

    public void setPenaltiesMissed(int penaltiesMissed) {
        this.penaltiesMissed = penaltiesMissed;
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