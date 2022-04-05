import { DiscountType } from "./discount-type";

export class DiscountCondition {
  private _type: DiscountType;
  private _sequence: number;
  private _dayOfWeek: number;
  private _startTime: Date;
  private _endTime: Date;
  constructor(
    type: DiscountType,
    sequence: number,
    dayOfWeek: number,
    startTime: Date,
    endTime: Date
  ) {
    this._type = type;
    this._sequence = sequence;
    this._dayOfWeek = dayOfWeek;
    this._startTime = startTime;
    this._endTime = endTime;
  }

  get type(): DiscountType {
    return this._type;
  }

  set type(value: DiscountType) {
    this._type = value;
  }

  get sequence(): number {
    return this._sequence;
  }

  set sequence(value: number) {
    this._sequence = value;
  }

  get dayOfWeek(): number {
    return this._dayOfWeek;
  }

  set dayOfWeek(value: number) {
    this._dayOfWeek = value;
  }

  get startTime(): Date {
    return this._startTime;
  }

  set startTime(value: Date) {
    this._startTime = value;
  }

  get endTime(): Date {
    return this._endTime;
  }

  set endTime(value: Date) {
    this._endTime = value;
  }
}
