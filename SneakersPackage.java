package mission.Week3Project;

public class SneakersPackage {

    private Sneakers sneakers;

    public SneakersPackage() {
    }

    public void setASneakers(Sneakers sneakers){
        this.sneakers = sneakers;
    }

    public Sneakers beUnBoxed(){
        return sneakers;
    }
}
