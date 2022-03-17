import { Ticket } from "./ticket.entity";
import { Audience } from "./audience.entity";

export interface CreateTicketOfficeDto {
  amount: number;
  ticketList: Ticket[];
}

export class TicketOffice {
  constructor(private amount: number, private ticketList: Ticket[]) {}

  public sellTicketTo(audience: Audience) {
    this.plusAmount(audience.buy(this.getTicket()));
  }

  private getTicket() {
    return this.ticketList.shift();
  }

  private plusAmount(amount: number) {
    this.amount += amount;
  }

  private minusAmount(amount: number) {
    this.amount -= amount;
  }
}
