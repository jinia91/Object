import { Movie } from "./movie";

export class Screening {
  private _movie: Movie;
  private _sequence: number;
  private _whenScreened: Date;
  constructor(movie: Movie, sequence: number, whenScreened: Date) {
    this._movie = movie;
    this._sequence = sequence;
    this._whenScreened = whenScreened;
  }

  get movie(): Movie {
    return this._movie;
  }

  set movie(value: Movie) {
    this._movie = value;
  }

  get sequence(): number {
    return this._sequence;
  }

  set sequence(value: number) {
    this._sequence = value;
  }

  get whenScreened(): Date {
    return this._whenScreened;
  }

  set whenScreened(value: Date) {
    this._whenScreened = value;
  }
}
