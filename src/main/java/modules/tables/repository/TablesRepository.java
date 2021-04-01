package modules.tables.repository;

import lombok.extern.slf4j.Slf4j;
import commons.sessions.SessionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TablesRepository implements ITablesRepository {
    private static final String QUERY_ALL_TABlES = "SELECT * FROM ALL_TABLES WHERE OWNER = ?";
    private static final String COLUMN_TABLE_NAME = "TABLE_NAME";
    private final Connection connection = SessionFactory.getInstance();

    @Override
    public List<String> getAllTables() {
        try (PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_TABlES)) {
            String login = connection.getMetaData().getUserName();
            preparedStatement.setString(1, login);
            final ResultSet resultSet = preparedStatement.executeQuery();
            return convertToTablesNamesList(resultSet);
        } catch (SQLException throwables) {
            log.warn("", throwables);
            //TODO: what to do when throws exceptions
        }

        return Collections.emptyList();
    }

    private List<String> convertToTablesNamesList(ResultSet resultSet) throws SQLException {
        List<String> tablesNames = new ArrayList<>();
        while (resultSet.next()) {
            String currentName = resultSet.getString(COLUMN_TABLE_NAME);
            tablesNames.add(currentName);
        }
        return tablesNames;
    }
}
