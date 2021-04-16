package commons.sqlbuilder.predicates;

import java.util.NoSuchElementException;

public class MoreEqualPredicate extends AbstractPredicate {
    private Object moreEqual;

    @Override
    public String toSql() {
        String expression = getExpression().orElseThrow(NoSuchElementException::new);
        return PredicateUtil.greaterOrEquals(expression, moreEqual).toSql();
    }
}
