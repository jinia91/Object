import { Ticket } from "./ticket.entity";
import { Audience } from "./audience.entity";
import { InsufficientTicketError } from "../errors/insufficient-ticket-error";

export class TicketOffice {
  constructor(private amount: number, private ticketList: Ticket[]) {}

  public sellTicketTo(audience: Audience) {
    this.plusAmount(audience.buy(this.getTicket()));
  }

  private getTicket() {
    const issuedTicket = this.ticketList.shift();
    if (issuedTicket !== undefined) {
      return issuedTicket;
    }
    throw InsufficientTicketError;
  }

  private plusAmount(amount: number) {
    this.amount += amount;
  }

  private minusAmount(amount: number) {
    this.amount -= amount;
  }
}
