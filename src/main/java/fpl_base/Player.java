package fpl_base;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Player implements Comparable<Player> {
    private int id;
    private String name;
    private double price;
    private int totalPoints;

    //ArrayList<fpl_base.GameWeekStat> stats;
    //HashMap<Double, GameWeekStat> stats;

    GameWeekStat[] stats;

    public Player(String name, double initialPrice, int totalPoints) {
        this.id = 0;
        this.name = name;
        this.price = initialPrice;
        this.totalPoints = totalPoints;
        //this.stats = new HashMap<>();
        stats = new GameWeekStat[39];
    }

    public Player(String name, double initialPrice) {
        this(name, initialPrice, 0);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getTotalPointsAtGw(double gw) {
        int points = 0;
        for(int i = 1; i < gw; i++) {
            //TODO: better solution (start with empty gameweeks)
            if(stats[i] != null) {
                points += stats[i].getPoints();
            }
        }
        return points;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public boolean hasStats(int round) {
        return stats[round] != null;
    }

    public void addStats(GameWeekStat gameWeekStat) {
        stats[gameWeekStat.getGameweek()] = gameWeekStat;
    }

    public GameWeekStat getStats(int round) {
        return (hasStats(round)? stats[round] : new GameWeekStat());
    }

    public String getType() {
        return "NaN";
    }

    public void printStats(int gw) {
        System.out.println("=== STATS ===");
       // System.out.println(name + ", " + position + ", " + team + ".");
        stats[gw].print();
    }

    public void printAll() {
        System.out.println("=== STATS ===");
        //System.out.println(name + ", " + position + ", " + team + ".");
        for(int i = 1; i < 38; i++) {
            if(hasStats(i)) {
                getStats(i).print();
            } else {
                 System.out.println(name + ", GW" + i + ": did not play."); //TODO: connect to team
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof  Player) && getName().equalsIgnoreCase(((Player) o).getName());
    }

    @Override
    public int compareTo(Player p) {
        if(this.getTotalPoints() > p.getTotalPoints()) return 1;
        else if(this.getTotalPoints() > p.getTotalPoints()) return -1;
        else return this.getName().compareTo(p.getName());
    }
}
