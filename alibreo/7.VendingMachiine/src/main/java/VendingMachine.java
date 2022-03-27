public class VendingMachine {
    private Money money = new Money(0);

    public Item purchase(String itemName) {
        Item item = Item.createItem(itemName);
        if (item != null && item.isAvailableWith(money)) {
            money = money.minus(item.getPrice());
            return item;
        }
        return null;
    }

    public void receiveMoney(Money inputMoney) {
        money = money.add(inputMoney);
    }

    public Money getRemainMoney() {
        return money;
    }

    public void receiveCard(Card card) {
        money = card.getMoney();
    }

    public Payment prepare(String item) {
        return new Payment(this, item);
    }
}
