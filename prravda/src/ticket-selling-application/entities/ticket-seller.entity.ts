import { TicketOffice } from "./ticket-office.entity";

export class TicketSeller {
  constructor(private ticketOffice: TicketOffice) {}
  public getTicketOffice() {
    return this.ticketOffice;
  }
}
