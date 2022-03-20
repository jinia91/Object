package chapter2.application;

import chapter2.model.Screening;

public class SequenceCondition implements DiscountCondition{

    private int standardSequence;

    public SequenceCondition(int standardSequence) {
        this.standardSequence = standardSequence;
    }

    @Override
    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(standardSequence);
    }
}
