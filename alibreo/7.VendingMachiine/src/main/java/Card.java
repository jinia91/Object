public class Card implements Payabler {
    private Money remain;

    public Card(Money money) {
        remain = money;
    }

    @Override
    public Money payMoney(Money money) {
        if (remain.minus(money) == null) {
            return null;
        }
        remain = remain.minus(money);
        return money;
    }

    @Override
    public Money remainMoney() {
        return remain;
    }
}
