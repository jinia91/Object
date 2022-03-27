public class Card {
    public Money getMoney() {
        return remain;
    }

    private Money remain;

    public Card(Money money) {
        remain = money;
    }
}
