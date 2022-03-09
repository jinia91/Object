package chapter1.ver3;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buyTicket(Ticket ticket){
        if(bag.hasInvitation()) {
            bag.setTicket(ticket);
            return 0L;
        }
        bag.setTicket(ticket);
        bag.minusAmount(ticket.getFee());
        return ticket.getFee();
    }
}
