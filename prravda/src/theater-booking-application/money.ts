export interface CreateMoneyDto {
  amount: number;
}

export class Money {
  public static ZERO = Money.wons(0);
  private readonly amount: number;
  constructor(createMoneyDto: CreateMoneyDto) {
    const { amount } = createMoneyDto;
    this.amount = amount;
  }

  public static wons(amount: number) {
    return new Money({ amount });
  }
  public plus(amount: Money) {
    return new Money({ amount: this.amount + amount.amount });
  }

  public minus(amount: Money) {
    return new Money({ amount: this.amount - amount.amount });
  }

  public times(percent: number) {
    return new Money({ amount: this.amount * percent });
  }

  public isLessThan(other: Money) {
    return this.amount < other.amount;
  }

  public isGreaterThanOrEqual(other: Money) {
    return this.amount >= other.amount;
  }
}
