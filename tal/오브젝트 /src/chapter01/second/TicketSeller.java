package chapter01.second;

public class TicketSeller { //Audience 에서 내부구조 변겅 
	private TicketOffice ticketOffice;
	
	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}
	
	public void sellTo(Audience audience) {
		ticketOffice.SellTicktTo(audience); //TicketOffice 내부구조 변경  
	}
}
