package modules.clients.repository;

import commons.repository.Repository;
import modules.clients.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientsRepository extends Repository<Client> {
    List<String> getColumns() throws SQLException;
}
