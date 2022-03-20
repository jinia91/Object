import { Screening } from "./screening";
import { Money } from "./money";

export class Reservation {
  constructor(
    private customer: Customer,
    private screening: Screening,
    private fee: Money,
    private audienceCount: number
  ) {}
}
