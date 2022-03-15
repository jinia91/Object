package chapter1.ver6.ticketseller;

import chapter1.ver6.audience.Audience;
import chapter1.ver6.ticketoffice.TicketOffice;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        audience.buyTicket(ticketOffice.issueTicket());
    }
}
