// SafeDelete가 머지?
public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    //추상클래스는 오버라이드안써도되나?
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
