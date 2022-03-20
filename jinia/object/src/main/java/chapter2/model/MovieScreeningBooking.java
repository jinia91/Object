package chapter2.model;

public class MovieScreeningBooking {
    private Customer customer;
    private Screening screening;
    private Money totalFee;
    private Integer audienceCount;

    public MovieScreeningBooking(Customer customer, Screening screening, Money totalFee, Integer audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.totalFee = totalFee;
        this.audienceCount = audienceCount;
    }
}
