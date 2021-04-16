package commons.sqlbuilder.predicates;

import java.util.Optional;

public abstract class AbstractPredicate implements Predicate {
    private String expression;

    public void setParameter(String expression) {
        this.expression = expression;
    }

    public Optional<String> getExpression() {
        return Optional.of(expression);
    }
}
