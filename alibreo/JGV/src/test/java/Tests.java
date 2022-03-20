import org.junit.jupiter.api.Test;

import java.time.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Tests {

    @Test
    public void test_Money_equals_테스트() {
        assertThat(Money.wons(800)).isEqualTo(Money.wons(800));
        assertThat(Money.wons(800)).isNotEqualTo(Money.wons(700));
    }

    @Test
    public void test_Avatar_할인() {
        assertThat("1").isEqualTo("1");
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(Money.wons(800),
                        new SequenceCondition(10),
                        new SequenceCondition(1),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0), LocalTime.of(20, 59))));
        Screening screening = new Screening(avatar, 10, LocalDateTime.now());
        Money money = screening.getMovieFee();

        assertThat(money).isEqualTo(Money.wons(800));
    }
}
