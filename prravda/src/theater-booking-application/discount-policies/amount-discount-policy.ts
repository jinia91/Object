import { AbstractDiscountPolicy } from "./abstract.discount-policy";
import { DiscountCondition } from "../discount-conditions/discount-condition";
import { Screening } from "../screening";
import { Money } from "../money";

export class AmountDiscountPolicy extends AbstractDiscountPolicy {
  constructor(private discountAmount: Money, conditions: DiscountCondition[]) {
    super(conditions);
  }

  protected getDiscountAmount(screening: Screening): Money {
    return this.discountAmount;
  }
}
