package chapter1.ver3;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    public void sellTo(Audience audience){
        Long money = audience.buyTicket(ticketOffice.issueTicket());  // 티켓판매원은 관객의 명세에만 의존, 구현은 알지 못함!
        ticketOffice.plusAmount(money);
    }
}
