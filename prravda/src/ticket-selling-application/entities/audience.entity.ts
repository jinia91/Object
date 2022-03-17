import { Bag } from "./bag.entity";
import { Ticket } from "./ticket.entity";

export class Audience {
  constructor(private bag: Bag) {}
  public buy(ticket: Ticket) {
    return this.bag.hold(ticket);
  }
}
