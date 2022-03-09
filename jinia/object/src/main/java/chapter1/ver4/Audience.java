package chapter1.ver4;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public long buyTicket(Ticket ticket){
        return bag.hold(ticket);
    }
}
