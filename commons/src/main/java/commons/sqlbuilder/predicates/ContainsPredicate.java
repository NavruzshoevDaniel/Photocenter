package commons.sqlbuilder.predicates;

import java.util.NoSuchElementException;

public class ContainsPredicate extends AbstractPredicate {
    private Object containsValues;

    @Override
    public String toSql() {
        String expression = getExpression().orElseThrow(NoSuchElementException::new);
        return PredicateUtil.contains(expression, containsValues).toSql();
    }
}
