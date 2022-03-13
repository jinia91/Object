import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TicketTests {
    @Test
    public void test_이벤트에_당첨된사람은_초대장을_티켓으로_교환해서_입장한다() {
        // Given
        TicketOffice ticketOffice = new TicketOffice(3L, new Ticket(1L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Invitation invitation = new Invitation();
        Bag bag = new Bag(3L, invitation);
        Audience audience = new Audience(bag);

        // When
        theater.enter(audience);

        // Then
//        assertThat().isEqualTo(true);
    }

    @Test
    public void test_이벤트에_당첨되지않은사람은_티켓을_구매해야만_입장할수있다() {
        // Given
        TicketOffice ticketOffice = new TicketOffice(3L, new Ticket(1L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Bag bag = new Bag(3L);
        Audience audience = new Audience(bag);

        // When
        theater.enter(audience);

        // Then
//        assertThat(audience.getBag().hasTicket()).isEqualTo(true);
    }
}
