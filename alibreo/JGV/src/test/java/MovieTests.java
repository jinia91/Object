import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class MovieTests {
    Customer customerDummy;

    @BeforeEach
    public void setUp() {
        customerDummy = new Customer();
    }

    @Test
    public void test_Money_equals_테스트() {
        assertThat(Money.wons(800)).isEqualTo(Money.wons(800));
        assertThat(Money.wons(800)).isNotEqualTo(Money.wons(700));
    }

    @Test public void test_n명이_관람을하러갔을경우_n배만큼의비용이발생한다() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                null);
        Screening screening = new Screening(avatar, 10, LocalDateTime.now());

        Reservation reservation = screening.reserve(customerDummy, 2);

        assertThat(reservation.getFee()).isEqualTo(Money.wons(20000));
    }

    @Test
    public void test_Avatar는_매일10번째_상영일경우_일정금액할인받는다() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDefaultDiscountPolicy(Money.wons(800),
                        new SequenceCondition(10),
                        new SequenceCondition(1),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
        Screening screening = new Screening(avatar, 10, LocalDateTime.now());

        Reservation reserve = screening.reserve(customerDummy, 1);

        assertThat(reserve.getFee()).isEqualTo(Money.wons(9200));
    }

    @Test
    public void test_Avatar는_매일10번째_상영이아닐경우_할인정책을받지못한다() {
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDefaultDiscountPolicy(Money.wons(800),
                        new SequenceCondition(10),
                        new SequenceCondition(1),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
        Screening screening = new Screening(avatar, 9, LocalDateTime.now());

        Reservation reservation = screening.reserve(customerDummy, 1);

        assertThat(reservation.getFee()).isNotEqualTo(Money.wons(9200));
    }

    @Test
    public void test_Titanic은_2회_상영일경우_일정비율할인받는다() {
        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new PercentDefaultDiscountPolicy(0.1,
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0), LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(13, 59))));
        Screening screening = new Screening(titanic, 2, LocalDateTime.now());

        Reservation reservation = screening.reserve(customerDummy, 1);

        assertThat(reservation.getFee()).isEqualTo(Money.wons(9900));
    }

    @Test
    public void test_스타워즈는_할인이_없다() {
        Movie starwars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDefaultDiscountPolicy());
        Screening screening = new Screening(starwars, 1, LocalDateTime.now());

        Reservation reservation = screening.reserve(customerDummy, 1);

        assertThat(reservation.getFee()).isEqualTo(Money.wons(10000));
    }
}
