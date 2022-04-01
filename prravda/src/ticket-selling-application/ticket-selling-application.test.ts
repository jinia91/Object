import { Movie } from "../theater-booking-application/movie";
import { AmountDiscountPolicy } from "../theater-booking-application/discount-policies/amount-discount-policy";
import { PercentDiscountPolicy } from "../theater-booking-application/discount-policies/percent-discount-policy";

describe("ticket selling application test", () => {
  const avatarMovie = new Movie(
    "avatar",
    120,
    10000,
    new AmountDiscountPolicy(new PercentDiscountPolicy(0.1))
  );
  beforeAll();
});
