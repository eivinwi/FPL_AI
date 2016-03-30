package fpl_base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.io.*;


@SpringBootApplication
@ComponentScan({"fpl_base", "rest", "service"})
public class Main {
    private PlayerPool playerPool;
    private League league;

    @Autowired
    public void setPlayerPool(PlayerPool playerPool) {
        this.playerPool = playerPool;
    }

    @Autowired
    public void setLeague(League league) {
        this.league = league;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    private void setup() {
        System.out.println("Reading files and creating structures...");
        readFile("data/14-15_fixed.csv", 2014);
    }

    private void readFile(String fileName, int season) {
        try {
            InputStream is = new FileInputStream(new File(fileName));
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
                //Old_GameWeekStat gameWeekStat = new Old_GameWeekStat(s);
                String playerName = s[0];
                String teamName = s[16];
                String position = s[21];
                if(!league.hasTeam(teamName)) {
                    league.addTeam(new Team(teamName));
                }

                Team team = league.getTeam(teamName);
                if (!playerPool.hasPlayer(playerName)) {
                    switch (position) {
                        case "GKP":
                            GoalKeeper gk = new GoalKeeper(playerName, teamName);
                            gk.addStats(season, s);
                            playerPool.addPlayer(gk);
                            team.addGoalKeepers(gk);
                            break;
                        case "DEF":
                            Defender defender = new Defender(playerName, teamName);
                            defender.addStats(season, s);
                            playerPool.addPlayer(defender);
                            team.addDefender(defender);
                            break;
                        case "MID":
                            Midfielder midfielder = new Midfielder(playerName, teamName);
                            midfielder.addStats(season, s);
                            playerPool.addPlayer(midfielder);
                            team.addMidfielder(midfielder);
                            break;
                        case "FWD":
                            Striker striker = new Striker(playerName, teamName);
                            striker.addStats(season, s);
                            playerPool.addPlayer(striker);
                            team.addStriker(striker);
                            break;
                        default:
                            System.out.println("fpl_base.Player " + playerName + " has invalid type:" + position + ".");
                            return;
                    }
                }
                Player p = playerPool.getPlayer(playerName);
                if(!isDouble) {
                    //p.addStats(gameWeekStat);
                    //Todo: create Match class
                    //team.addTeamStats(gameWeekStat);
                } else {
                    //Old_GameWeekStat gwSingle = p.getStats(Integer.parseInt(s[20]));
                    //gwSingle.setDoubleGw(gameWeekStat);
                    //team.getStats(Integer.parseInt(s[20])).setDoubleGw(gameWeekStat);
                    //Todo: redo DoubleGW mechanism
                }

            }
        } catch (Exception e) {
            System.err.println("Error during file read: " + e);
        } finally {
            //TODO: create Mactches in finally??
        }
    }
}
