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
        assertThat(ticketOffice.getAmount()).isEqualTo(1L);
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

    @Test
    public void test_초대장이_있는사람은_무료로_티켓을_얻는다() {
        // Given
        TicketOffice ticketOffice = new TicketOffice(1L, new Ticket(1L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Invitation invitation = new Invitation();
        Bag bag = new Bag(1L, invitation);
        Audience audience = new Audience(bag);

        // When
        ticketSeller.sellTo(audience);

        // Then
        assertThat(ticketOffice.getAmount()).isEqualTo(1L);
        assertThat(ticketOffice.getTickets().size()).isEqualTo(0);
    }

    @Test
    public void test_초대장이_없는사람은_티켓_가격만큼_돈을_지불한다() {
        // Given
        TicketOffice ticketOffice = new TicketOffice(1L, new Ticket(1L));
        TicketSeller ticketSeller = new TicketSeller(ticketOffice);
        Theater theater = new Theater(ticketSeller);
        Bag bag = new Bag(1L);
        Audience audience = new Audience(bag);

        // When
        ticketSeller.sellTo(audience);

        // Then
        assertThat(ticketOffice.getAmount()).isEqualTo(2L);
        assertThat(ticketOffice.getTickets().size()).isEqualTo(0);
    }
}
