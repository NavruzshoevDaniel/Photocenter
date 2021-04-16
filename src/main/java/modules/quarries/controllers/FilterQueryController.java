package modules.quarries.controllers;

import commons.sqlbuilder.CriteriaBuilder;
import commons.sqlbuilder.predicates.Predicate;
import modules.quarries.dto.SearchCriteria;
import modules.quarries.mappers.IQueryMapper;
import modules.quarries.mappers.SearchCriteriaMapper;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

public class FilterQueryController implements IFilterQueryController {
    private static final Path QUERIES_PROPERTY = Paths.get("queries", "unfiltredQueries.properties");
    private static Properties properties;
    private final String propertyQueryKey;

    public FilterQueryController(String propertyQueryKey) throws IOException {
        this.propertyQueryKey = propertyQueryKey;
        if (properties == null) {
            properties = new Properties();
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(QUERIES_PROPERTY.toString());
            Objects.requireNonNull(resourceAsStream, QUERIES_PROPERTY + " not found");
            properties.loadFromXML(resourceAsStream);
        }
    }

    @Override
    public void postSearchCriteria(List<SearchCriteria> searchCriteria, IQueryMapper queryMapper) {
        List<Predicate> predicates = searchCriteria.stream()
                .map(criteria -> map(criteria, queryMapper))
                .map(SearchCriteriaMapper::convert)
                .collect(Collectors.toList());
        String query = properties.getProperty(propertyQueryKey);
        Objects.requireNonNull(query, propertyQueryKey);
        CriteriaBuilder criteriaBuilder = new CriteriaBuilder();
        predicates.stream()
                .map(Predicate::toSql)
                .forEach(criteriaBuilder::where);
        String unfiletredQuery = properties.getProperty(propertyQueryKey);
        String filteredQuery = unfiletredQuery + criteriaBuilder.toString();
    }


    private SearchCriteria map(SearchCriteria searchCriteria, IQueryMapper mapper) {
        String sqlExpression = mapper.getSqlExpression();
        return new SearchCriteria(sqlExpression, searchCriteria.getOperation(), searchCriteria.getValue());
    }
}
