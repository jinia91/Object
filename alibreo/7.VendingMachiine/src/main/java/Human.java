// 사람이란 객체는 Paylable한 객체이면서 Paylable 객체를 소유하고있는 객체임 -> 재밌는 이슈
public class Human implements Payabler {
    private Money wallet;
    private Card card;

    public Human(Money wallet, Card card) {
        this.wallet = wallet;
        this.card = card;
    }

    //더 앨래강스한방법은 없을까요?
    public Human(Money wallet) {
        this.wallet = wallet;
        this.card = null;
    }

    @Override
    public Money payMoney(Money money) {
        return wallet;
    }

    @Override
    public Money remainMoney() {
        return wallet;
    }
}
