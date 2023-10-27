package mission.Week3Project;

public class Customer {

  private boolean likeDelivery;
  private long cash;
  private String myFeeling;

  public Customer(){
    this.myFeeling = "보통";
  }

  public boolean isAffordable(long cashRequired){
    return this.cash >= cashRequired;
  }

  public boolean isLikeDelivery(){
    return likeDelivery;
  }

  public void sayBye(){
    System.out.printf("손님: 아.. 그럼, 다음에 올게요~ 기분이 %s이고, 잔액 %d원 남았습니다.\n", this.myFeeling, this.cash);
  }

  public void sayOrder(){
    System.out.println("손님: 네 좋네요, 주문 계속 진행할게요.");
  }

  public void askNikeSneakersToStaff(Staff staff){
    System.out.println("손님: Nike 운동화에 대해서 알려주세요.");
    staff.answerNikeSneakersInfo();
  }

  public long askAndGetSneakersPriceFromStaff(Staff staff){
    return staff.answerNikeSneakersPrice();
  }

  public long askAndGetDeliveryCostFromDeliveryManager(DeliveryManager deliveryManager){
    return deliveryManager.answerDeliveryCost();
  }

  public long makePayment(long nikePrice){
    this.cash -= nikePrice;
    return nikePrice;
  }

  public void setLikeDelivery(boolean likeDelivery) {
    this.likeDelivery = likeDelivery;
  }

  public void setCash(long cash) {
    this.cash = cash;
  }

  public void wearSneakers(Sneakers sneakers){
    this.myFeeling = "좋음";
    System.out.printf("손님: 이 신발은 %s의 특징이 느껴지네요, 기분이 %s이고, 잔액 %d원 남았습니다.\n",
            sneakers.getSneakersInfo().getFeature(), this.myFeeling, this.cash);
  }

  public void requireRefund(){
    System.out.println("손님: 배송료가 너무 비싸네요, 신발 가격 환불해 주세요.");
  }

  public void getRefund(long cash){
    this.cash += cash;
  }
}
