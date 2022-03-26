public class VendingMachine {
    private Money money = new Money(0);

    public Item purchase(String itemName) {
        if (itemName == "Water" && money.isBiggerOrEqual(new Money(500))) {
            money.minus(new Money(500));
            return new Water();
        } else if (itemName == "Cola" && money.isBiggerOrEqual(new Money(1000))) {
            money.minus(new Money(1000));
            return new Cola();
        }
        return null;
    }

    public void receiveMoney(Money inputMoney) {
        this.money.add(inputMoney);
    }

    public Money getRemainMoney() {
        return money;
    }
}
