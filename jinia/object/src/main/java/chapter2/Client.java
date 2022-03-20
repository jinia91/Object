package chapter2;

import chapter2.application.AmountDiscountPolicy;
import chapter2.application.PeriodCondition;
import chapter2.application.SequenceCondition;
import chapter2.model.Money;
import chapter2.model.Movie;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Client {

    public static void main(String[] args) {
        Movie avatar = new Movie(1L, "아바타",
                Duration.ofMinutes(120),
                Money.wons(1000),
                new AmountDiscountPolicy(Money.wons(120),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),LocalTime.of(11,59)),
                new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10,0), LocalTime.of(20, 59))));

    }
}
