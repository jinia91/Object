import { Invitation } from "./invitation.entity";
import { Ticket } from "./ticket.entity";

export class Bag {
  constructor(
    private amount: number,
    private invitation: Invitation,
    private ticket: Ticket
  ) {}


  private setTicket(ticket: Ticket) {
    this.ticket = ticket;
  }

  private minusAmount(amount: number) {
    this.amount -= amount;
  }

  private plusAmount(amount: number) {
    this.amount += amount;
  }

  public hasInvitation() {
    return this.invitation !== null;
  }

  public hasTicket() {
    return this.ticket !== null;
  }

  public hold(ticket: Ticket) {
    if (this.hasInvitation()) {
      this.setTicket(ticket);
    }
    this.setTicket(ticket);
    this.minusAmount(ticket.getFee());
    return ticket.getFee();
  }
}
