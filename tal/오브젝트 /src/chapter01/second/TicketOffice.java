package chapter01.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice { // audiene에 의존하지만 결합도를 낮춤 
	private Long amount;
	private List<Ticket> tickets = new ArrayList<>();
	
	
	public void SellTicktTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}
	
	private Ticket getTicket() {
		return tickets.remove(0);
	}
	
	private void plusAmount(Long amount) {
		this.amount += amount;
	}
}
