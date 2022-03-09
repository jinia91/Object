package chapter1.ver1;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        if(audience.getBag().hasInvitation()){  // 디미터법칙에 위배되는 코드, 현재 코드는 영화관이 관객에게 가방을 달라한 다음, 그 가방에게 초대장을 달라고 하고있다.
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();  // 또한 객체지향적인 접근이 아닌, 자료구조로서 접근하고 있는 상황
            audience.getBag().setTicket(ticket);
        } else {
            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
            audience.getBag().minusAmount(ticket.getFee());
            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
            audience.getBag().setTicket(ticket);
        }
    }
}
