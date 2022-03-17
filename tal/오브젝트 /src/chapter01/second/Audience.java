package chapter01.second;

public class Audience { // bag 내부구조 변경 
	private Bag bag;
	
	public Audience(Bag bag) {
		this.bag = bag;
	}
	
	public Long buy(Ticket ticket) {
		return bag.hold(ticket);
	}
}
