package chapter1.ver6.audience;

import chapter1.ver6.bag.Bag;
import chapter1.ver6.ticket.Ticket;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long buyTicket(Ticket ticket){
        return bag.hold(ticket);
    }
}
