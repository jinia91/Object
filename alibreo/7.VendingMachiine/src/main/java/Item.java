import lombok.Getter;

@Getter
public abstract class Item {
    private final Money price;

    public Item(Money price) {
        this.price = price;
    }

    public boolean isAvailableWith(Money money) {
        return money.isBiggerOrEqual(price);
    }

    public static Cola createCola() {
        return new Cola(new Money(1000));
    }

    public static Water createWater() {
        return new Water(new Money(500));
    }

    public static Item createItem(String itemName) {
        if (itemName == "Cola") {
            return createCola();
        } else if (itemName == "Water") {
            return createWater();
        }
        return null;
    }
}
