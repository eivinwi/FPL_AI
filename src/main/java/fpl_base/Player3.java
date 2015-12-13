package fpl_base;

@SuppressWarnings("unused")
public class Player3 implements Comparable<Player3> {
    private int id;
    private String name;
    private double price;
    private int totalPoints;

    //ArrayList<fpl_base.GameWeekStat> stats;
    //HashMap<Double, GameWeekStat> stats;

    GameWeekStat[] stats;

    public Player3(String name, double initialPrice, int totalPoints) {
        this.id = 0;
        this.name = name;
        this.price = initialPrice;
        this.totalPoints = totalPoints;
        //this.stats = new HashMap<>();
        stats = new GameWeekStat[39];
    }

    public Player3(String name, double initialPrice) {
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
        return getTotalPointsAtGw(39);
    }

    public int getTotalPointsAtGw(int gw) {
        int points = 0;
        for(int i = 1; i < gw; i++) {
            if(stats[i] != null) {
                points += stats[i].getPoints();
            }
        }
        return points;
    }

    public Double pointsPerMin() {
        return ((double) getTotalPoints() /(double) minutesPlayed());
    }

    public Double pointsPerMatch() {
        return ((double) getTotalPoints() /(double) matchesPlayed());
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

    public int matchesPlayed(int week) {
        int played = 0;
        for(int i = 1; i < week; i++) {
            GameWeekStat gw = stats[i];
            if(gw != null && gw.getMinutesPlayed() > 0) {
                played++;
            }
        }
        return played;
    }

    public int matchesPlayed() {
        return matchesPlayed(39);
    }

    public int minutesPlayed(int week) {
        int played = 0;
        for(int i = 1; i < week; i++) {
            GameWeekStat gw = stats[i];
            if(gw != null) {
                played += gw.getMinutesPlayed();
            }
        }
        return played;
    }

    public int minutesPlayed() {
        return minutesPlayed(39);
    }

    public int goals() {
        int goals = 0;
        for(GameWeekStat gws : stats) {
            if (gws != null) {
                goals += gws.getGoalsScored();
            }
        }
        return goals;
    }

    public Double goalsPerMin() {
        return (double) goals() / (double) minutesPlayed();
    }

    public Double minsPerGoal() {
        return (double) minutesPlayed() / (double) goals();
    }

    public Double goalsPerMatch() {
        return (double) goals() / (double) matchesPlayed();
    }

    public Double averagePoints(int gw) {
        return (double) getTotalPointsAtGw(gw) / (double) matchesPlayed(gw);
    }

    public Double averagePoints() {
        return averagePoints(39);
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
        return (o instanceof Player3) && getName().equalsIgnoreCase(((Player3) o).getName());
    }

    @Override
    public int compareTo(Player3 p) {
        if(this.getTotalPoints() > p.getTotalPoints()) return 1;
        else if(this.getTotalPoints() > p.getTotalPoints()) return -1;
        else return this.getName().compareTo(p.getName());
    }
}
