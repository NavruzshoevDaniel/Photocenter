package modules.clients.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import lombok.extern.slf4j.Slf4j;
import modules.clients.entity.Client;

import java.sql.*;

import java.util.List;

@Slf4j
public class ClientRepository implements IClientsRepository {

    @Override
    public void add(Client obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Client obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Client obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Client> getAll() throws SQLException {
        return RepositoryUtil.getAll(Client.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        List<String> columnNames = RepositoryUtil.getColumns(Client.class);
        log.info(columnNames.toString());
        return columnNames;
    }
}
