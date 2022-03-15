package chapter1.ver6.theater;

import chapter1.ver6.ticketseller.TicketSeller;
import chapter1.ver6.audience.Audience;

public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        ticketSeller.sellTo(audience);  // 극장은 티켓셀러의 명세에만 의존, 티켓셀러가 실제로 뭘 가지고 있는지 더이상 알 필요가 없음  = 인터페이스로 바꿔도 문제없어짐!
    }
}
