import { MovieType } from "./movie-type";

export class Movie {
  private _title: string;
  private _runningTime: Duration;
  private _fee: Money;
  private _discountConditions: DiscountCondition[];
  private _movieType: MovieType;
  private _discountAmount: Money;
  private _discountPercent: number;
  constructor(
    title: string,
    runningTime: Duration,
    fee: Money,
    discountConditions: DiscountCondition[],
    movieType: MovieType,
    discountAmount: Money,
    discountPercent: number
  ) {
    this._title = title;
    this._runningTime = runningTime;
    this._fee = fee;
    this._discountConditions = discountConditions;
    this._movieType = movieType;
    this._discountAmount = discountAmount;
    this._discountPercent = discountPercent;
  }

  get title(): string {
    return this._title;
  }

  set title(value: string) {
    this._title = value;
  }

  get runningTime(): Duration {
    return this._runningTime;
  }

  set runningTime(value: Duration) {
    this._runningTime = value;
  }

  get fee(): Money {
    return this._fee;
  }

  set fee(value: Money) {
    this._fee = value;
  }

  get discountConditions(): DiscountCondition[] {
    return this._discountConditions;
  }

  set discountConditions(value: DiscountCondition[]) {
    this._discountConditions = value;
  }

  get movieType(): MovieType {
    return this._movieType;
  }

  set movieType(value: MovieType) {
    this._movieType = value;
  }

  get discountAmount(): Money {
    return this._discountAmount;
  }

  set discountAmount(value: Money) {
    this._discountAmount = value;
  }

  get discountPercent(): number {
    return this._discountPercent;
  }

  set discountPercent(value: number) {
    this._discountPercent = value;
  }
}
