import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Money {
    private int won;

    public Money(int won) {
        this.won = won;
    }

    public void add(Money money) {
        this.won += money.won;
    }

    public void minus(Money money) {
        this.won -= money.won;
    }

    public boolean isBiggerOrEqual(Money money) {
        return this.won >= money.won;
    }
}
