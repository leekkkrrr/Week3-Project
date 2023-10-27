package mission.Week3Project;

public class SneakersPackageInfo {

    private int daysForDeliver;
    private int cost;

    public SneakersPackageInfo(int daysForDeliver, int cost){
        this.daysForDeliver = daysForDeliver;
        this.cost = cost;
    }

    public int getDaysForDeliver() {
        return daysForDeliver;
    }

    public int getCost() {
        return cost;
    }
}
