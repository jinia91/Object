package chapter01.second;

public class Theater { //TicketSeller에서 내부구조 변경 
	private TicketSeller ticketSeller;
	
	public Theater(TicketSeller ticketSeller) {
		this.ticketSeller = ticketSeller;
	}
	
	public void enter(Audience audience) {
		ticketSeller.sellTo(audience);
	}
}
