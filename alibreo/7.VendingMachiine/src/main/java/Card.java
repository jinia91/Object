public class Card {
    private Money remain;

    public Card(Money money) {
        remain = money;
    }

    public Money withdrawMoney(Money money) {
        if (remain.minus(money) == null) {
            return null;
        }
        remain = remain.minus(money);
        return money;
    }

    public Money remainMoney() {
        return remain;
    }
}
