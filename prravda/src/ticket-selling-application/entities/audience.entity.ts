import { Bag } from "./bag.entity";

export class Audience {
  constructor(private bag: Bag) {}
  public getBag() {
    return this.bag;
  }
}
