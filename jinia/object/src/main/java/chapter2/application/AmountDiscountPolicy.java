package chapter2.application;

import chapter2.model.Money;
import chapter2.model.Screening;

public class AmountDiscountPolicy extends DiscountSkeletonPolicy{
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
