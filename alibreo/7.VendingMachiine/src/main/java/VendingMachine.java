public class VendingMachine {
    private Money remianMoney = new Money(0);
    private Money ownersMoney = new Money(0);
    private Payabler payabler;

    public Item purchase(String itemName) {
        Item item = Item.createItem(itemName);
        if (item == null) {
            return null;
        }
        Money price = item.getPrice();
        remianMoney = remianMoney.add(payabler.payMoney(price));
        if (remianMoney.isBiggerOrEqual(price)) {
            remianMoney.add(price);
            remianMoney = remianMoney.minus(price);
            return item;
        }
        return null;
    }

    public Money getRemainMoney() {
        return remianMoney;
    }

    public void startWith(Payabler payabler) {
        this.payabler = payabler;
    }

    public Payment prepare(String item) {
        return new Payment(this, item);
    }
}
