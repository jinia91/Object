import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 템플릿 메소드 패턴 예제
public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    public List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(List<DiscountCondition> conditions) {
        this.conditions = conditions;
    }

    public DefaultDiscountPolicy(DiscountCondition... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    // 붙여주는게?
    final public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
