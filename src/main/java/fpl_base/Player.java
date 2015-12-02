package fpl_base;

import java.util.HashMap;

@SuppressWarnings("unused")
public class Player implements Comparable<Player> {
    private int id;
    private String name;
    private double price;
    private int totalPoints;

//    ArrayList<fpl_base.GameWeekStat> stats;
    HashMap<Double, GameWeekStat> stats;

    public Player(String name, double initialPrice, int totalPoints) {
        this.id = 0;
        this.name = name;
        this.price = initialPrice;
        this.totalPoints = totalPoints;
        this.stats = new HashMap<>();
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
        for(double d = 1.0; d < gw; d++) {
            //TODO: better solution (start with empty gameweeks)
            if(stats.get(d) != null) {
                points += stats.get(d).getPoints();
            }
        }
        return points;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public boolean hasStats(double round) {
        return stats.containsKey(round);
    }

    public void addStats(GameWeekStat gameWeekStat) {
        stats.put(gameWeekStat.getGameweek(), gameWeekStat);
    }

    public GameWeekStat getStats(double round) {
        return (hasStats(round)? stats.get(round) : new GameWeekStat());
    }

    public String getType() {
        return "NaN";
    }

    public void printStats(double gw) {
        System.out.println("=== STATS ===");
       // System.out.println(name + ", " + position + ", " + team + ".");
        stats.get(gw).print();
    }

    public void printAll() {
        System.out.println("=== STATS ===");
        //System.out.println(name + ", " + position + ", " + team + ".");
        for(double d = 1.0; d < 38.0; d++) {
            if(hasStats(d)) {
                getStats(d).print();
            } else {
                 System.out.println(name + ", GW" + d + ": did not play."); //TODO: connect to team
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
