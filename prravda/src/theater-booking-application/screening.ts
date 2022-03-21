import { CreateScreeningDto } from "./dto/create-screening-dto";
import { Movie } from "./movie";
import { Reservation } from "./reservation";

export class Screening {
  constructor(
    private movie: Movie,
    private sequence: number,
    private whenScreened: Date
  ) {}

  private calculateFee(audienceCount: number) {
    return this.movie.calculateMovieFee().times(audienceCount);
  }

  public reserve(customer: Customer, audienceCount: number) {
    return new Reservation(
      customer,
      this,
      this.calculateFee(audienceCount),
      audienceCount
    );
  }

  public getStartTime() {
    return this.whenScreened;
  }

  public isSequence(sequence: number) {
    return this.sequence === sequence;
  }

  public getMovieFee() {
    return this.movie.getFee();
  }
}
