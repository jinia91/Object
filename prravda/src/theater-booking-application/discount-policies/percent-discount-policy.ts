import { AbstractDiscountPolicy } from "./abstract.discount-policy";
import { DiscountCondition } from "../discount-conditions/discount-condition";
import { Screening } from "../screening";
import { Money } from "../money";

export class PercentDiscountPolicy extends AbstractDiscountPolicy {
  constructor(
    private discountPercent: number,
    conditions: DiscountCondition[]
  ) {
    super(conditions);
  }

  protected getDiscountAmount(screening: Screening): Money {
    return screening.getMovieFee().times(this.discountPercent);
  }
}
