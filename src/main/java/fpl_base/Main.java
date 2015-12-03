package fpl_base;

import java.io.*;

public class Main {
    static PlayerPool players;
    static League league;

    public static void main(String[] args) {
        System.out.println("Hello World!" +
                "");
        setup();

       // LinkedList<fpl_base.Player> pgw = league.getTeam("SWA").getTeamInGameWeek(28.0);
        /*for(fpl_base.Player p : pgw) {
            System.out.print(p.getName() + "(" + p.getStats(1.0).getMinutesPlayed() + "), ");
        }
        System.out.println();*/
       // league.getTeam("SWA").showPlayers();
        //league.getTeam("MUN").showPlayersByGw(38.0);
        //league.showTeams();

      //  System.out.println("GW " + 38.0 + ": " + league.getTeam("LIV").totalPointsAtGameweek(38.0));
     //   league.showTable(38.0);
       // for(Team t : league.getTeams()) {
         //   System.out.println(t.getName() + ": " + t.totalPoints());
       // }
        for(Object o : league.goalsPerMin(players.getStrikers(), 0)) {
            Player p = (Player) o;
            System.out.println(p.getName() + " (" + p.matchesPlayed() + "," + p.goals() + "): " + p.minsPerGoal());
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
                GameWeekStat gameWeekStat = new GameWeekStat(s);

                if(!league.hasTeam(gameWeekStat.getTeam())) {
                    league.addTeam(new Team(gameWeekStat.getTeam()));
                }
                Team team = league.getTeam(gameWeekStat.getTeam());
                if (!players.hasPlayer(gameWeekStat.getName())) {
                    switch (gameWeekStat.getPosition()) {
                        case "GKP":
                            GoalKeeper gk = new GoalKeeper(gameWeekStat.getName(), gameWeekStat.getSeasonStartPrice());
                            players.addPlayer(gk);
                            team.addGoalKeepers(gk);
                            break;
                        case "DEF":
                            Defender defender = new Defender(gameWeekStat.getName(), gameWeekStat.getSeasonStartPrice());
                            players.addPlayer(defender);
                            team.addDefender(defender);
                            break;
                        case "MID":
                            Midfielder midfielder = new Midfielder(gameWeekStat.getName(), gameWeekStat.getSeasonStartPrice());
                            players.addPlayer(midfielder);
                            team.addMidfielder(midfielder);
                            break;
                        case "FWD":
                            Striker striker = new Striker(gameWeekStat.getName(), gameWeekStat.getSeasonStartPrice());
                            players.addPlayer(striker);
                            team.addStriker(striker);
                            break;
                        default:
                            System.out.println("fpl_base.Player " + gameWeekStat.getName() + " has invalid type:" + gameWeekStat.getPosition() + ".");
                            return;
                    }
                }
                Player p = players.getPlayer(gameWeekStat.getName());
                if(!isDouble) {
                    p.addStats(gameWeekStat);
                    team.addTeamStats(gameWeekStat);
                } else {
                    GameWeekStat gwSingle = p.getStats(Integer.parseInt(s[20]));
                    gwSingle.setDoubleGw(gameWeekStat);
                    team.getStats(Integer.parseInt(s[20])).setDoubleGw(gameWeekStat);
                }

            }
         } catch (Exception e) {
            System.err.println("Error during file read: " + e);
        }
    }
}
