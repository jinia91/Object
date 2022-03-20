import { DiscountCondition } from "./discount-condition";
import { Screening } from "../screening";

// Table of dayOfWeek
// 0: sunday
// 1: monday
// ...
// 6: saturday

export class PeriodDiscountCondition implements DiscountCondition {
  constructor(
    private readonly dayOfWeek: number,
    private readonly startTime: Date,
    private readonly endTime: Date
  ) {}
  public isSatisfiedBy(screening: Screening): boolean {
    return Boolean(
      screening.getStartTime().getDay() === this.dayOfWeek &&
        this.startTime <= screening.getStartTime() &&
        this.endTime >= screening.getStartTime()
    );
  }
}
