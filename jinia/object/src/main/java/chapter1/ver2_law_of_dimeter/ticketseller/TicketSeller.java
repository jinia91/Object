package chapter1.ver2_law_of_dimeter.ticketseller;

import chapter1.ver2_law_of_dimeter.ticketoffice.TicketOffice;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public TicketOffice a() {
        return ticketOffice;
    }
}
