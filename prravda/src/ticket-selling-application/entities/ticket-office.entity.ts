import { Ticket } from "./ticket.entity";

export interface CreateTicketOfficeDto {
  amount: number;
  ticketList: Ticket[];
}

export class TicketOffice {
  constructor(private amount: number, private ticketList: Ticket[]) {}

  public handOverTicket() {
    return this.ticketList.shift();
  }

  public plusAmount(amount: number) {
    this.amount += amount;
  }

  public minusAmount(amount: number) {
    this.amount -= amount;
  }
}
