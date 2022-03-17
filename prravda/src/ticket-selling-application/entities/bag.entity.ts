import { Invitation } from "./invitation.entity";
import { Ticket } from "./ticket.entity";

export class Bag {
  constructor(
    private amount: number,
    private invitation: Invitation,
    private ticket: Ticket
  ) {}

  public hasInvtation() {
    return this.invitation !== null;
  }

  public hasTicket() {
    return this.ticket !== null;
  }

  public setTicket(ticket: Ticket) {
    this.ticket = ticket;
  }

  public minusAmount(amount: number) {
    this.amount -= amount;
  }

  public plusAmount(amount: number) {
    this.amount += amount;
  }
}
