package modules.clients.controller;

import lombok.extern.slf4j.Slf4j;
import modules.clients.entity.Client;
import modules.clients.repository.ClientRepository;
import modules.clients.repository.IClientsRepository;
import modules.clients.view.IClientsView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
public class ClientsController implements IClientsController {
    private final IClientsView clientsView;
    private final IClientsRepository clientRepository = new ClientRepository();

    public ClientsController(IClientsView view) {
        this.clientsView = view;
    }

    @Override
    public void getColumnNames() {
        try {
            clientRepository.getColumns()
                    .stream()
                    .map(column -> column.replace("_", " "))
                    .forEach(clientsView::setColumnName);
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
            clientsView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void getClientsRows() {
        try {
            clientRepository.getAll()
                    .stream()
                    .map(this::mapToFieldsObjects)
                    .forEach(clientsView::addClientRow);
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
            clientsView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void updateRow(Map<String, Object> parameters) {

        try {
            final Client client = new Client(parameters);
            clientRepository.update(client);
        } catch (SQLException | IllegalAccessException | ClassCastException e) {
            log.warn(e.getMessage(), e);
            clientsView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void addNewClient(Map<String, Object> parameters) {
        try {
            clientRepository.add(new Client(parameters));
        } catch (SQLException | IllegalAccessException | ClassCastException e) {
            log.warn(e.getMessage(), e);
            clientsView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void deleteRows(List<Map<String, Object>> listParameters) {
        for (Map<String, Object> parameters : listParameters) {
            try {
                clientRepository.remove(new Client(parameters));
            } catch (SQLException | IllegalAccessException e) {
                log.warn(e.getMessage(), e);
                clientsView.showErrorMessage(e.getMessage());
            }
        }
    }

    private Object[] mapToFieldsObjects(Client client) {
        return client.toObjects().toArray();
    }
}
