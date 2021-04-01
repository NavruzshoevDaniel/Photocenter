package modules.clients.repository;

import com.sun.rowset.JdbcRowSetImpl;
import lombok.extern.slf4j.Slf4j;
import modules.clients.entity.Client;
import commons.sessions.SessionFactory;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ClientRepository implements IClientsRepository {
    private static final String SELECT_ALL_CLIENTS = "SELECT * FROM CLIENTS";
    private final Connection connection = SessionFactory.getInstance();

    @Override
    public Client getById(long id) {
        //TODO: realize
        return null;
    }

    @Override
    public void add(Client obj) {

    }

    @Override
    public void remove(Client obj) {

    }

    @Override
    public void update(Client obj) {

    }

    @Override
    public List<Client> getAll() throws SQLException {
        JdbcRowSetImpl jdbcRowSet = new JdbcRowSetImpl(connection);
        jdbcRowSet.setCommand(SELECT_ALL_CLIENTS);
        jdbcRowSet.execute();
        List<Client> clients = new ArrayList<>();
        while (jdbcRowSet.next()) {
            Client client = new Client();
            client.setId(jdbcRowSet.getInt("id"));
            client.setFirstName(jdbcRowSet.getString("first_name"));
            client.setSecondName(jdbcRowSet.getString("second_name"));
            client.setMiddleName(jdbcRowSet.getString("middle_name"));
            client.setProfessional(jdbcRowSet.getInt("is_professional") == 1);
            client.setDiscount(jdbcRowSet.getInt("discount") == 1);
            clients.add(client);
        }
        return clients;
    }

    @Override
    public List<String> getColumns() throws SQLException {
        final ArrayList<String> columnNames = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CLIENTS);
            final ResultSetMetaData metaData = resultSet.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                columnNames.add(metaData.getColumnName(i));
            }
        }
        log.info(columnNames.toString());
        return columnNames;
    }
}
