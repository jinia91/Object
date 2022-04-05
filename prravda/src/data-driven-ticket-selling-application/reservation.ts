import { Screening } from "./screening";

export class Reservation {
  private _customer: Customer;
  private _screening: Screening;
  private _fee: Money;
  private _audienceCount: number;
  constructor(
    customer: Customer,
    screening: Screening,
    fee: Money,
    audienceCount: number
  ) {
    this._customer = customer;
    this._screening = screening;
    this._fee = fee;
    this._audienceCount = audienceCount;
  }

  get customer(): Customer {
    return this._customer;
  }

  set customer(value: Customer) {
    this._customer = value;
  }

  get screening(): Screening {
    return this._screening;
  }

  set screening(value: Screening) {
    this._screening = value;
  }

  get fee(): Money {
    return this._fee;
  }

  set fee(value: Money) {
    this._fee = value;
  }

  get audienceCount(): number {
    return this._audienceCount;
  }

  set audienceCount(value: number) {
    this._audienceCount = value;
  }
}
