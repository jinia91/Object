public class VendingMachine {
    public Item purchase(Money money, String itemName) {
        if (itemName == "Water") {
            return new Water();
        }
        return new Cola();
    }
}
