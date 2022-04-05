package chapter2.application;

import chapter2.model.Money;
import chapter2.model.Screening;

public class NoneDiscountPolicy implements DiscountPolicy{
    @Override
    public Money calculationDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
