package modules.quarries.mappers;

import commons.sqlbuilder.predicates.Predicate;
import commons.sqlbuilder.predicates.PredicateUtil;
import lombok.experimental.UtilityClass;
import modules.quarries.dto.SearchCriteria;

import java.util.NoSuchElementException;

@UtilityClass
public class SearchCriteriaMapper {

    public static Predicate convert(SearchCriteria criteria) {
        String key = criteria.getKey().getSqlExpression();
        Object value = criteria.getValue();
        return criteria.getOperation().apply(key, value);
    }
}
