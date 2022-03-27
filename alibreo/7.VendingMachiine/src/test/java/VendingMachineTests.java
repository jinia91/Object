import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class VendingMachineTests {
    @Test
    public void test_VendingMachine은_1000원을_넣으면_콜라가나온다() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money(1000);
        vendingMachine.startWith(new Human(new Money(1000)));

        Item item = vendingMachine.purchase("Cola");

        assertThat(item instanceof Cola).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine은_500원으로_물을살수있다() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money(500);
        vendingMachine.startWith(new Human(new Money(500)));

        Item item = vendingMachine.purchase("Water");

        assertThat(item instanceof Water).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine에_400원을넣으면_물을구매할수없다() {
        VendingMachine vendingMachine = new VendingMachine();
        Money money = new Money(400);
        vendingMachine.startWith(new Human(new Money(400)));

        Item item = vendingMachine.purchase("Water");

        assertThat(item).isNull();
    }

    @Test
    public void test_VendingMachine에_1000원을넣으면_물을두번뽑을수있다() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.startWith(new Human(new Money(1000)));
        Item item1 = vendingMachine.purchase("Water");
        Item item2 = vendingMachine.purchase("Water");

        assertThat(item1 instanceof Water).isEqualTo(true);
        assertThat(item2 instanceof Water).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine에_600원을넣고_물을사면_잔돈으로100원을얻는다() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.startWith(new Human(new Money(600)));
        Item item = vendingMachine.purchase("Water");
        Money remainMoney = vendingMachine.getRemainMoney();

        assertThat(item instanceof Water).isEqualTo(true);
        assertThat(remainMoney).isEqualTo(new Money(100));
    }

    @Test
    public void test_VendingMachine은_카드로도_음료수를_결제할_수_있다() {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.startWith(new Card(new Money(500)));
        Item item = vendingMachine.purchase("Water");

        assertThat(item instanceof Water).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine은_음료수를선택하고_카드를입력받을수도있다() {
        VendingMachine vendingMachine = new VendingMachine();

        Payment payment = vendingMachine.prepare("Water");
        Item item = payment.settle(new Card(new Money(500)));

        assertThat(item instanceof Water).isEqualTo(true);
    }

    @Test
    public void test_VendingMachine에_카드로결제시_결제금액만큼돈이빠진다() {
        VendingMachine vendingMachine1 = new VendingMachine();

        Card card1 = new Card(new Money(600));
        vendingMachine1.startWith(card1);
        vendingMachine1.purchase("Water");
        Money money1 = card1.remainMoney();

        assertThat(money1).isEqualTo(new Money(100));

        VendingMachine vendingMachine2 = new VendingMachine();

        Payment payment = vendingMachine2.prepare("Water");
        Card card2 = new Card(new Money(600));
        payment.settle(card2);
        Money money2 = card2.remainMoney();

        assertThat(money2).isEqualTo(new Money(100));
    }
}
