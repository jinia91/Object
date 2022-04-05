package chapter3;

public class ReservationAgency {
    // old
//    public Reservation reserve(Customer customer, Screening screening, int audienceCount) {
//        Movie movie = screening.getMovie();
//        // 해당하는 정책 찾기
//        boolean discountable = false;
//        for (DiscountCondition discountCondition : movie.getDiscountConditions()) {
//            if (discountCondition.getType() == DiscountConditionType.PERIOD) {
//                discountable = screening.getWhenScreened().getDayOfWeek().equals(discountCondition.getDayOfWeek()) &&
//                        discountCondition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
//                        discountCondition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
//            } else {
//                discountable = discountCondition.getSequence() == screening.getSequence();
//            }
//            if(discountable) break;
//        }
//
//        // 정책으로 요금 정하기
//        Money fee;
//
//        if(discountable) {
//            Money discountAmount = null;
//            switch (movie.getMovieType()) {
//                case AMOUNT_DISCOUNT:
//                    discountAmount = movie.getDiscountAmount();
//                    break;
//                case PERCENT_DISCOUNT:
//                    discountAmount = movie.getFee().times(movie.getDiscountPercent());
//                    break;
//                case NONE_DISCOUNT:
//                    discountAmount = Money.ZERO;
//                    break;
//            }
//            fee = movie.getFee().minus(discountAmount);
//        }else {
//            fee = movie.getFee();
//        }
//        return new Reservation(customer, screening, fee, audienceCount);
//    }

    // refactoring
    public Reservation reserve(Customer customer, Screening screening, int audienceCount){
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(customer, screening, fee, audienceCount);
    }
}
