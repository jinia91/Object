import { Screening } from "./screening";
import { Money } from "../theater-booking-application/money";
import { AmountDiscountPolicy } from "../theater-booking-application/discount-policies/amount-discount-policy";
import { MovieType } from "./movie-type";

export class ReservationAgency {
  constructor(
    private screening: Screening,
    private customer: Customer,
    private audienceCount: number
    private reservation: Reservation,
  ) {
    let discountable: boolean = false;
    const discountConditionList = screening.movie.discountConditions;
    for (const eachCondition of discountConditionList) {
      if (discountable) {
        break;
      }
      if (eachCondition.type === "PERIOD") {
        discountable = Boolean(
          screening.whenScreened.getDay() === eachCondition.dayOfWeek &&
            eachCondition.startTime.getTime() >
              screening.whenScreened.getTime() &&
            eachCondition.endTime.getTime() < screening.whenScreened.getTime()
        );
      }
      discountable = Boolean(eachCondition.sequence === screening.sequence);

      let fee: Money;
      if (discountable) {
        let discountAmount: Money = Money.ZERO;
        switch (screening.movie) {
          case MovieType.AMOUNT_DISCOUNT:
            discountAmount = screening.movie.discountAmount;
            break;
          case MovieType.PERCENT_DISCOUNT:
            discountAmount = screening.movie.discountPercent;
            break;
            case MovieType.NONE_DISCOUNT:
            default:
            discountAmount = screening.movie.;
            break;
        }
          fee = screening.movie.fee.minus(dicountAmount);
      } else {
          fee = screening.movie.fee;
      }
      this.reservation = new Reservation(this.customer, this.screening, fee, audienceCount);
    }
  }
}
