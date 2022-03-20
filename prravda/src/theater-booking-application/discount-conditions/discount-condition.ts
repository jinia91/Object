import { Screening } from "../screening";

export interface DiscountCondition {
  isSatisfiedBy(screening: Screening): boolean;
}
