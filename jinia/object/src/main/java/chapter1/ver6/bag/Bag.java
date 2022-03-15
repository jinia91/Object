package chapter1.ver6.bag;

import chapter1.ver6.invitation.Invitation;
import chapter1.ver6.ticket.Ticket;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Bag(Long amount) {
        this.amount = amount;
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    public Long hold(Ticket ticket) {
        if(hasInvitation()) {
            setTicket(ticket);
            return 0L;
        }
        setTicket(ticket);
        minusAmount(ticket.getFee());
        return ticket.getFee();
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean hasTicket() {
        return ticket != null;
    }
}
