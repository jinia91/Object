public class Payment {
    private VendingMachine vendingMachine;
    private String itemName;

    public Payment(VendingMachine vendingMachine, String itemName) {
        this.vendingMachine = vendingMachine;
        this.itemName = itemName;
    }

    // 고민: payment라는 객체에게 돈계산에 대한 로직을 맡겨버리는 건 다 좋은데, 이 객체를 신뢰해도되는가?
    public Item settle(Payabler payabler) {
        vendingMachine.startWith(payabler);
        return vendingMachine.purchase(itemName);
    }
}
