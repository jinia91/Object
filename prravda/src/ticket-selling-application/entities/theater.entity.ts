import { TicketSeller } from "./ticket-seller.entity";
import { Audience } from "./audience.entity";

export class Theater {
  constructor(private ticketSeller: TicketSeller) {}

  public enter(audience: Audience) {
    if (audience.getBag().hasTicket()) {
      const ticket = this.ticketSeller.getTicketOffice().handOverTicket();
      audience.getBag().setTicket(ticket);
    }
    const ticket = this.ticketSeller.getTicketOffice().handOverTicket();
    audience.getBag().minusAmount(ticket.getFee());
    this.ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
    audience.getBag().setTicket(ticket);
  }
}
