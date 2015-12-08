package fpl_base;

/**
 * Created by eivwik on 08.12.15.
 */
@SuppressWarnings("Duplicates")
public class Player2 {
    private static final int rounds = 39; //38+1 to avoid having to constantly convert gameweek to -1 for arrays
    private String name;

    // FPL
    private boolean[] played = new boolean[rounds];
    private double[] price = new double[rounds];
    private double[] ownedPercent = new double[rounds];
    private int[] points = new int[rounds];
    private double seasonStartPrice;
    private double seasonEndprice;

    // FPL Points
    private int[] minutesPlayed = new int[rounds];
    private int[] goals = new int[rounds];
    private int[] assists = new int[rounds];
    private int[] cleanSheet = new int[rounds];
    private int[] goalsConceded = new int[rounds];
    private int[] ownGoals = new int[rounds];
    private int[] penaltiesSaved = new int[rounds];
    private int[] penaltiesMissed = new int[rounds];
    private int[] yellowCards = new int[rounds];
    private int[] redCards = new int[rounds];
    private int[] saves = new int[rounds];
    private int[] bonus = new int[rounds];
    private int[] bonusSystemScoring = new int[rounds];
    private int[] EA_SPORTS_PPI = new int[rounds];

    // Match
    private String[] opponent = new String[rounds];
    private boolean[] atHome = new boolean[rounds];
    private String[] posititon = new String[rounds];
    private int[] difficultyRank = new int[rounds];
    private String[] difficultyDesc = new String[rounds];
    private int[] PID;
    private String[] position = new String[rounds]; //TODO: array necessary?
    private String[] date = new String[rounds];
    private String[] kickoffTime = new String[rounds];



    public Player2() {

    }


    public void addStats(String[] s) {
        if(s.length < 30) { //Todo: check
            System.out.println("Line array too short");
        } else if(s[20].contains(".")) {
            System.out.println("Double gameweek entered as single.");
        }
        int gw = Integer.parseInt(s[20]);

        if(played[gw]) {
            System.out.println("Attempting to re-add gameweek stats.");
        }
        else {
            if(name == null) {
                name = s[0];
            }
            if(name.equals(s[0])) {
                System.err.println("Name is not equal: " + s[0] + " and " + name);
            }
            minutesPlayed[gw] = Integer.parseInt(s[1]);
            goals[gw] = Integer.parseInt(s[2]);
            assists[gw] = Integer.parseInt(s[3]);
            cleanSheet[gw] = Integer.parseInt(s[4]);
            goalsConceded[gw] = Integer.parseInt(s[5]);
            ownGoals[gw] = Integer.parseInt(s[6]);
            penaltiesSaved[gw] = Integer.parseInt(s[7]);
            penaltiesMissed[gw] = Integer.parseInt(s[8]);
            yellowCards[gw] = Integer.parseInt(s[9]);
            redCards[gw] = Integer.parseInt(s[10]);
            saves[gw] = Integer.parseInt(s[11]);
            bonus[gw] = Integer.parseInt(s[12]);
            EA_SPORTS_PPI[gw] = Integer.parseInt(s[13]);
            bonusSystemScoring[gw] = Integer.parseInt(s[14]);
            points[gw] = Integer.parseInt(s[15]);

            //team = s[16]; //TODO: people can change teams internally in PL!!
            //score = s[17];

            opponent[gw] = s[18];
            atHome[gw] = s[19].equalsIgnoreCase("home");
            position[gw] = s[21];
            difficultyRank[gw] = Integer.parseInt(s[22]);
            difficultyDesc[gw] = s[23];
            PID[gw] = Integer.parseInt(s[24]);
            ownedPercent[gw] = s[25].contains(".")? Double.parseDouble(s[25]) : Integer.parseInt(s[25]);
            date[gw] = s[26];
            kickoffTime[gw] = s[27];
            seasonStartPrice = s[28].contains(".")? Double.parseDouble(s[28]) : Integer.parseInt(s[28]);
            seasonEndprice = s[29].contains(".")? Double.parseDouble(s[29]) : Integer.parseInt(s[29]);
        }
    }

}
