package chapter1.ver2_law_of_dimeter.theater;

import chapter1.ver2_law_of_dimeter.ticket.Ticket;
import chapter1.ver2_law_of_dimeter.ticketseller.TicketSeller;
import chapter1.ver2_law_of_dimeter.audience.Audience;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        if(audience.getBag().hasInvitation()){
            Ticket ticket = ticketSeller.a().getTicket();
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.a().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.a().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
