import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@ToString
@EqualsAndHashCode
@Value
public class Money {
    private int won;

    public Money(int won) {
        this.won = won;
    }

    public Money add(Money money) {
        return new Money(won + money.won);
    }

    public Money minus(Money money) {
        if (won - money.won < 0) {
            return null;
        }
        return new Money(won - money.won);
    }

    public boolean isBiggerOrEqual(Money money) {
        return this.won >= money.won;
    }
}
