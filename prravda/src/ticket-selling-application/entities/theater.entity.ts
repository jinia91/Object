import { TicketSeller } from "./ticket-seller.entity";
import { Audience } from "./audience.entity";

export class Theater {
  constructor(private ticketSeller: TicketSeller) {}
  public enter(audience: Audience) {
    this.ticketSeller.sellTo(audience);
  }
}
