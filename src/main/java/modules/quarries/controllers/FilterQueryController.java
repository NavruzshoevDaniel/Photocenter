package modules.quarries.controllers;

import commons.sessions.SessionFactory;
import commons.sqlbuilder.CriteriaBuilder;
import commons.sqlbuilder.predicates.Predicate;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import modules.quarries.dto.RowDto;
import modules.quarries.dto.SearchCriteria;
import modules.quarries.dto.TableDto;
import modules.quarries.mappers.ColumnsMapper;
import modules.quarries.mappers.SearchCriteriaMapper;
import modules.quarries.views.IFilterQueryView;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.stream.Collectors;

@Slf4j
public class FilterQueryController implements IFilterQueryController {
    private static final Path QUERIES_PROPERTY = Paths.get("queries", "unfiltredQueries.xml");
    private static Properties properties;
    private final String propertyQueryKey;
    @Setter
    private IFilterQueryView filterQueryView;

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
    public void postSearchCriteria(List<SearchCriteria> searchCriteria) {
        String filteredQuery = prepareFiltredQuery(searchCriteria);
        try (Statement statement = SessionFactory.getInstance().createStatement()) {
            final ResultSet resultSet = statement.executeQuery(filteredQuery);
            final List<String> columns = parseColumns(resultSet.getMetaData());
            log.info(columns.toString());
            final List<String> mappedColumns = columns.stream()
                    .map(ColumnsMapper::mapColumn)
                    .collect(Collectors.toList());
            final List<RowDto> rowDtos = parseRows(resultSet);
            filterQueryView.updateTable(new TableDto(mappedColumns, rowDtos));
        } catch (SQLException throwables) {
            log.error(throwables.getMessage(), throwables);
        }

    }

    private String prepareFiltredQuery(List<SearchCriteria> searchCriteria) {
        List<Predicate> predicates = searchCriteria.stream()
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
        log.info(filteredQuery);
        return filteredQuery;
    }


    private List<String> parseColumns(ResultSetMetaData metaData) throws SQLException {
        final ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            columns.add(metaData.getColumnName(i));
        }
        return columns;
    }

    private List<RowDto> parseRows(ResultSet resultSet) throws SQLException {
        final ArrayList<RowDto> rows = new ArrayList<>();
        while (resultSet.next()) {
            final ArrayList<Object> rowValues = new ArrayList<>();
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                rowValues.add(resultSet.getObject(i));
            }
            rows.add(new RowDto(rowValues));
        }
        return rows;
    }

}
