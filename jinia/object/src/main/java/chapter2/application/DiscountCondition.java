package chapter2.application;

import chapter2.model.Money;
import chapter2.model.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
