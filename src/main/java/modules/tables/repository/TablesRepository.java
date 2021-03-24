package modules.tables.repository;

import lombok.extern.slf4j.Slf4j;
import modules.commons.sessions.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TablesRepository implements ITablesRepository {
    private static final String QUERY_ALL_TABlES = "SELECT * FROM ALL_TABLES WHERE OWNER = ?";

    @Override
    public List<String> getAllTables() {
        String login = ConnectionFactory.getInstance().getUserLogin();
        try (Connection connection = ConnectionFactory.getInstance().createConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_TABlES)) {
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
            String current_name = resultSet.getString("TABLE_NAME");
            tablesNames.add(current_name);
        }
        return tablesNames;
    }
}
