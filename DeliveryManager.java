package mission.Week3Project;

public class DeliveryManager {

    private long salesAmount;
    private SneakersInfo nikeSneakersInfo;
    private SneakersPackageInfo sneakersPackageInfo;

    public void setSalesAmount(long salesAmount) {
        this.salesAmount = salesAmount;
    }

    public void setNikeSneakersInfo(SneakersInfo nikeSneakersInfo) {
        this.nikeSneakersInfo = nikeSneakersInfo;
    }

    public void setSneakersPackageInfo(SneakersPackageInfo sneakersPackageInfo) {
        this.sneakersPackageInfo = sneakersPackageInfo;
    }

    public SneakersPackageInfo getSneakersPackageInfo() {
        return sneakersPackageInfo;
    }

    public SneakersPackage makeSneakersPackage(){
        System.out.println("배송 담당자: Sneakers 배송 완료되었습니다.");
        Sneakers nikeSneakers = new Sneakers(nikeSneakersInfo);
        SneakersPackage sneakersPackage = new SneakersPackage();
        return sneakersPackage;
    }

    public void sayPayment(long payment){
        System.out.printf("배송 담당자: 고객님 배송 결제 도와드리겠습니다. %d원 입니다.\n", payment);
    }

    public void addSalesAmount(long cashPackage){
        this.salesAmount += cashPackage;
    }

    public long answerDeliveryCost(){
        return sneakersPackageInfo.getCost();
    }
}
