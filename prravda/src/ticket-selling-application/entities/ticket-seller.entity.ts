import { TicketOffice } from "./ticket-office.entity";
import { Audience } from "./audience.entity";

export class TicketSeller {
  constructor(private ticketOffice: TicketOffice) {}
  public sellTo(audience: Audience) {
    this.ticketOffice.sellTicketTo(audience);
  }
}
