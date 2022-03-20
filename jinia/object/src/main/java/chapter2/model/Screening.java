package chapter2.model;

import java.time.ZonedDateTime;

public class Screening {

    private Long id;
    private Movie movie;
    private Integer sequence;
    private ZonedDateTime whenScreened;

    public Screening(Long id, Movie movie, Integer sequence, ZonedDateTime whenScreened) {
        this.id = id;
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public Long getId() {
        return id;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public boolean isSequence(Integer sequence) {
        return this.sequence.equals(sequence);
    }

    public ZonedDateTime getStartTime() {
        return whenScreened;
    }

    public MovieScreeningBooking booking(Customer customer, int audienceCount){
        return new MovieScreeningBooking(customer, this,calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
