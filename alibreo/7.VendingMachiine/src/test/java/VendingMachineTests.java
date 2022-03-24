import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VendingMachineTests {
    @Test
    public void test_VendingMachine은_1000원을_넣으면_콜라가나온다() {
        VendingMachine vendingMachine = new VendingMachine();

        Money money = new Money();
        Item item = vendingMachine.purchase(money, "Cola");

        assertThat(item instanceof Cola).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine은_500원으로_물을살수있다() {
        VendingMachine vendingMachine = new VendingMachine();

        Money money = new Money();
        Item item = vendingMachine.purchase(money, "Water");

        assertThat(item instanceof Water).isEqualTo(true);
    }
}
