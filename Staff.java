package mission.Week3Project;

public class Staff {
    private long salesAmount;
    private SneakersInfo nikeSneakersInfo;
    private boolean havingNikeSneakersInStore;

    public Staff() {
    }

    public void setSalesAmount(long salesAmount){
        this.salesAmount = salesAmount;
    }

    public void setNikeSneakersInfo(SneakersInfo nikeSneakersInfo) {
        this.nikeSneakersInfo = nikeSneakersInfo;
    }

    public void setHavingNikeSneakersInStore(boolean havingNikeSneakersInStore) {
        this.havingNikeSneakersInStore = havingNikeSneakersInStore;
    }

    public boolean checkHavingNikeSneakersInStore(){
        if (this.havingNikeSneakersInStore){
            System.out.println("직원: 현재 매장에 재고가 존재하네요. 바로 주문 진행 가능합니다.");
        }
        else {
            System.out.println("직원: 현재 매장에 재고가 존재하지않네요, 배송 주문 가능합니다.");
        }
        return havingNikeSneakersInStore;
    }

    public void answerNikeSneakersInfo(){
        System.out.printf("직원: 이 Nike 운동화는 %s 특징과 %d원 가격을 가지고 있습니다.\n",
                nikeSneakersInfo.getFeature(), nikeSneakersInfo.getPrice());
    }

    public long answerNikeSneakersPrice(){
        return this.nikeSneakersInfo.getPrice();
    }

    public void sayPayment(long payment){
        System.out.printf("직원: 고객님 신발 주문 도와드리겠습니다. %d원 입니다.\n", payment);
    }

    public void addSalesAmount(long cash){
        this.salesAmount += cash;
    }

    public Sneakers offerNikeSneakers(){
        return new Sneakers(this.nikeSneakersInfo);
    }

    public SneakersPackageInfo orderNikeSneakersToDeliveryManager(DeliveryManager deliveryManager){
        return deliveryManager.getSneakersPackageInfo();
    }
    public void sayNikePackageInfo(SneakersPackageInfo nikeSneakersPackageInfo){
        System.out.printf("직원: 고객님 배송은 %d일 걸릴 예정이고, 배송 금액은 %d원 소요됩니다.\n",
                nikeSneakersPackageInfo.getDaysForDeliver(), nikeSneakersPackageInfo.getCost());
    }

    public long calculateDeliveryCost(SneakersPackageInfo nikeSneakersPackageInfo){
        return nikeSneakersPackageInfo.getCost();
    }

    public long returnRefund(long cash){
        this.salesAmount -= cash;
        return cash;
    }
}
