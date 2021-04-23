package commons.sqlbuilder;

import commons.sqlbuilder.predicates.Predicate;
import commons.sqlbuilder.predicates.PredicateUtil;

import java.util.function.BiFunction;

public enum Operation {
    EQUAL(PredicateUtil::equals),
    GREATER_EQUALS(PredicateUtil::greaterOrEquals),
    LESS_EQUALS(PredicateUtil::lessOrEquals),
    IN(PredicateUtil::in),
    CONTAINS(PredicateUtil::contains),
    LIKE(PredicateUtil::like);

    private final BiFunction<String, Object, Predicate> predicateBiFunction;

    Operation(BiFunction<String, Object, Predicate> predicateBiFunction) {
        this.predicateBiFunction = predicateBiFunction;
    }

    public Predicate apply(String expression, Object value) {
        return predicateBiFunction.apply(expression, value);
    }
}
