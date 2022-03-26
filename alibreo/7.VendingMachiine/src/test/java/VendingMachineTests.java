import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VendingMachineTests {
    @Test
    public void test_VendingMachine은_1000원을_넣으면_콜라가나온다() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money(1000);
        vendingMachine.receiveMoney(money);

        Item item = vendingMachine.purchase("Cola");

        assertThat(item instanceof Cola).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine은_500원으로_물을살수있다() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money(500);
        vendingMachine.receiveMoney(money);

        Item item = vendingMachine.purchase("Water");

        assertThat(item instanceof Water).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine에_400원을넣으면_물을구매할수없다() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money(400);
        vendingMachine.receiveMoney(money);

        Item item = vendingMachine.purchase("Water");

        assertThat(item).isNull();
    }

    @Test
    public void test_VendingMachine에_1000원을넣으면_물을두번뽑을수있다() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.receiveMoney(new Money(1000));
        Item item1 = vendingMachine.purchase("Water");
        Item item2 = vendingMachine.purchase("Water");

        assertThat(item1 instanceof Water).isEqualTo(true);
        assertThat(item2 instanceof Water).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine에_600원을넣고_물을사면_잔돈으로100원을얻는다() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.receiveMoney(new Money(600));
        Item item = vendingMachine.purchase("Water");
        Money remainMoney = vendingMachine.getRemainMoney();

        assertThat(item instanceof Water).isEqualTo(true);
        assertThat(remainMoney).isEqualTo(new Money(100));
    }
}
