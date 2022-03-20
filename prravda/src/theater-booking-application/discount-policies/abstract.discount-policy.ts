import { Screening } from "../screening";
import { Money } from "../money";
import { DiscountCondition } from "../discount-conditions/discount-condition";

export abstract class AbstractDiscountPolicy {
  protected constructor(private conditions: DiscountCondition[]) {}

  protected abstract getDiscountAmount(screening: Screening): Money;

  public calculateDiscountAmount(screening: Screening) {
    for (const condition of this.conditions) {
      if (condition.isSatisfiedBy(screening)) {
        return this.getDiscountAmount(screening);
      }
    }
    return Money.ZERO;
  }
}
