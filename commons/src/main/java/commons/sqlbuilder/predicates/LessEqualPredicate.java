package commons.sqlbuilder.predicates;

import java.util.NoSuchElementException;

public class LessEqualPredicate extends AbstractPredicate {
    private Object lessEqual;

    @Override
    public String toSql() {
        String expression = getExpression().orElseThrow(NoSuchElementException::new);
        return PredicateUtil.lessOrEquals(expression, lessEqual).toSql();
    }
}
