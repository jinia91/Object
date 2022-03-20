import { Screening } from "./screening";
import { AbstractDiscountPolicy } from "./discount-policies/abstract.discount-policy";
import { Money } from "./money";

export class Movie {
  constructor(
    private title: string,
    private runningTime: Duration,
    private fee: Money,
    private discountPolicy: AbstractDiscountPolicy
  ) {}

  public getFee() {
    return this.fee;
  }

  public calculateMovieFee(screening: Screening) {
    return this.fee.minus(
      this.discountPolicy.calculateDiscountAmount(screening)
    );
  }
}
