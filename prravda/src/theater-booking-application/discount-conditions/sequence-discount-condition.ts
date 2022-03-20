import { DiscountCondition } from "./discount-condition";
import { Screening } from "../screening";

export class SequenceDiscountCondition implements DiscountCondition {
  constructor(private sequence: number) {}
  public isSatisfiedBy(screening: Screening): boolean {
    return screening.isSequence(this.sequence);
  }
}
