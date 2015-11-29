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
        for(Team t : league.getTeamsAlphabetically()) {
            System.out.println(t.getName());
        }

        for(Team t : league.getTeamsByPoints()) {
            System.out.println(t.totalPoints());
        }
    }

    protected static void setup() {
        league = new League();
        players = new PlayerPool();

        readFile();

    }

    private static void readFile() {
        try {
            InputStream is = new FileInputStream(new File("data/14-15_fixed.csv"));
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            @SuppressWarnings("UnusedAssignment") String line = br.readLine();
            while( (line = br.readLine()) != null) {
                String[] s = line.split(",");
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
                p.addStats(gameWeekStat);
                team.addTeamStats(gameWeekStat);
            }
         } catch (Exception e) {
            System.err.println("Error during file read: " + e);
        }
    }
}
