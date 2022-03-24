import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VendingMachineTests {
    @Test
    public void test_VendingMachine은_1000원을_넣으면_콜라가나온다() {
        VendingMachine vendingMachine = new VendingMachine();

        Cola cola = vendingMachine.purchase(money, "Cola");

        assertThat(cola.instanceOf(Cola)).isEqualto(true);
    }
}
