package fpl_base;

import java.io.*;

public class Main {
    static PlayerPool players;
    static League league;

    public static void main(String[] args) {
        System.out.println("Hello World!" +
                "");
        setup();


        //testPrint();
    }

    public static void testPrint() {
        for(Object o : league.top(players.getStrikers(), 0)) {
            Player3 p = (Player3) o;
            System.out.println(p.getName() + " (" + p.matchesPlayed() + "," + p.goals() + "): " + p.getTotalPoints());
        }
    }


    protected static void setup() {
        players = new PlayerPool();
        league = new League(players);

        readFile();

    }

    private static void readFile() {
        try {
            InputStream is = new FileInputStream(new File("data/14-15_fixed.csv"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            @SuppressWarnings("UnusedAssignment") String line = br.readLine();
            while( (line = br.readLine()) != null) {
                String[] s = line.split(",");

                boolean isDouble = false;
                if(s[20].contains(".")) {
                    String gw_num = s[20].substring(0, s[20].indexOf("."));
                    s[20] = gw_num;
                    isDouble = true;
                }
                //GameWeekStat gameWeekStat = new GameWeekStat(s);
                String playerName = s[0];
                String teamName = s[16];
                String position = s[21];
                if(!league.hasTeam(teamName)) { //gameWeekStat.getTeam())) {
                    //league.addTeam(new Team(gameWeekStat.getTeam()));
                    league.addTeam(new Team(teamName));
                }

                Team team = league.getTeam(teamName);
                if (!players.hasPlayer(playerName)) {
                    switch (position) {
                        case "GKP":
                            GoalKeeper gk = new GoalKeeper(s);
                            players.addPlayer(gk);
                            team.addGoalKeepers(gk);
                            break;
                        case "DEF":
                            Defender defender = new Defender(s);
                            players.addPlayer(defender);
                            team.addDefender(defender);
                            break;
                        case "MID":
                            Midfielder midfielder = new Midfielder(s);
                            players.addPlayer(midfielder);
                            team.addMidfielder(midfielder);
                            break;
                        case "FWD":
                            Striker striker = new Striker(s);
                            players.addPlayer(striker);
                            team.addStriker(striker);
                            break;
                        default:
                            System.out.println("fpl_base.Player " + playerName + " has invalid type:" + position + ".");
                            return;
                    }
                }
                Player p = players.getPlayer(playerName);
                if(!isDouble) {
                    //p.addStats(gameWeekStat);
                    //team.addTeamStats(gameWeekStat);
                    //Todo: create Match class
                } else {
                    //GameWeekStat gwSingle = p.getStats(Integer.parseInt(s[20]));
                    //gwSingle.setDoubleGw(gameWeekStat);
                    //team.getStats(Integer.parseInt(s[20])).setDoubleGw(gameWeekStat);
                    //Todo: redo DoubleGW mechanism
                }

            }
         } catch (Exception e) {
            System.err.println("Error during file read: " + e);
        }
    }
}
