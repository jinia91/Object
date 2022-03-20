package chapter2.model;

import chapter2.application.DiscountPolicy;

import java.time.Duration;

public class Movie {

    private Long id;
    private String title;
    private Duration runningTIme;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(Long id, String title, Duration runningTIme, Money fee, DiscountPolicy discountPolicy) {
        this.id = id;
        this.title = title;
        this.runningTIme = runningTIme;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculationDiscountAmount(screening));
    }

    public Money getFee() {
        return this.fee;
    }
}
