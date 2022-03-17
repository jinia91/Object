package chapter01.second;

public class Bag { // 내부구조 변경 
	private Long amount;
	private Invitation invitation;
	private Ticket ticket;
	
	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
			setTicket(ticket);
			return 0L;
		} else {
			setTicket(ticket);
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}
	
	
	private boolean hasInvitation() {
		return invitation != null;
	}
	
	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	private void minusAmount(Long amount) {
		this.amount -= amount;
	}
	
	public void plussAmount(Long amount) {
		this.amount += amount;
	}
}
