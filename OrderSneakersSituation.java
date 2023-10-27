package mission.Week3Project;

public class OrderSneakersSituation {
    public static void main(String[] args){
        // 변수 변경 가능
        // Customer 의 잔액, DeliveryManager 매상, Staff 매상은 모두 10만원 시작 입니다.

        boolean isCustomerLikeDelivery = false; // 고객의 배송 주문 선호 여부

        String nikeSneakersFeature = "안정감"; // 안정감 | 편안함 | 가벼움 등 신발 특징
        long nikeSneakersPrice = 50_000;
        boolean havingNikeSneakersInStore = true; // 매장 Nike sneakers 재고 여부

        int daysForDeliver = 3;
        int costForDeliver = 15_000;

        SneakersInfo nikeSneakersInfo = new SneakersInfo(nikeSneakersFeature, nikeSneakersPrice);
        SneakersPackageInfo sneakersPackageInfo = new SneakersPackageInfo(daysForDeliver, costForDeliver);

        Customer customer = new Customer();
        customer.setCash(100_000);
        customer.setLikeDelivery(isCustomerLikeDelivery);

        Staff staff = new Staff();
        staff.setSalesAmount(100_000);
        staff.setNikeSneakersInfo(nikeSneakersInfo);
        staff.setHavingNikeSneakersInStore(havingNikeSneakersInStore);

        DeliveryManager deliveryManager = new DeliveryManager();
        deliveryManager.setSalesAmount(100_000);
        deliveryManager.setNikeSneakersInfo(nikeSneakersInfo);
        deliveryManager.setSneakersPackageInfo(sneakersPackageInfo);

        // 여기서 로직
        customer.askNikeSneakersToStaff(staff);
        long nikePrice = customer.askAndGetSneakersPriceFromStaff(staff);

        if (!customer.isAffordable(nikePrice)){
            customer.sayBye();
            return;
        }

        if (staff.checkHavingNikeSneakersInStore()){
            customer.sayOrder();
            staff.sayPayment(nikePrice);
            long cash = customer.makePayment(nikePrice);
            staff.addSalesAmount(cash);

            Sneakers nikeSneakers = staff.offerNikeSneakers();
            customer.wearSneakers(nikeSneakers);
            return;
        }

        if (!customer.isLikeDelivery()){
            customer.sayBye();
            return;
        }

        customer.sayOrder();
        staff.sayPayment(nikePrice);
        long cash = customer.makePayment(nikePrice);
        staff.addSalesAmount(cash);

        SneakersPackageInfo nikeSneakersPackageInfo = staff.orderNikeSneakersToDeliveryManager(deliveryManager);
        staff.sayNikePackageInfo(nikeSneakersPackageInfo);
        long deliverCost = staff.calculateDeliveryCost(nikeSneakersPackageInfo);
        if (!customer.isAffordable(deliverCost)){
            customer.requireRefund();
            long refundCash = staff.returnRefund(cash);
            customer.getRefund(refundCash);
            customer.sayBye();
            return;
        }

        customer.sayOrder();
        SneakersPackage sneakersPackage = deliveryManager.makeSneakersPackage();
        long deliveryCost = customer.askAndGetDeliveryCostFromDeliveryManager(deliveryManager);
        deliveryManager.sayPayment(deliveryCost);

        long cashPackage = customer.makePayment(deliveryCost);
        deliveryManager.addSalesAmount(cashPackage);

        customer.wearSneakers(sneakersPackage.beUnBoxed());
    }
}
