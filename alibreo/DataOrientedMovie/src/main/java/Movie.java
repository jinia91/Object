import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.List;

@Setter
@Getter
public class Movie {
    private String title;
    private Duration runningTIme;
    private Money fee;
    private List<DiscountCondition> discountConditionList;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;
}
