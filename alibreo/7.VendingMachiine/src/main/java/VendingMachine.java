public class VendingMachine {
    private Money money = new Money(0);
    private Card card;

    public Item purchase(String itemName) {
        Item item = Item.createItem(itemName);
        if (item == null) {
            return null;
        }
        Money price = item.getPrice();
        if (item.isAvailableWith(money)) {
            money = money.minus(price);
            return item;
        } else if (card != null && item.isAvailableWith(card.withdrawMoney(price))) {
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
        this.card = card;
    }

    public Payment prepare(String item) {
        return new Payment(this, item);
    }
}
