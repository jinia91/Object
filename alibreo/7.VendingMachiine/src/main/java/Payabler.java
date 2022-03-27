public interface Payabler {
    Money payMoney(Money money);

    Money remainMoney();
}