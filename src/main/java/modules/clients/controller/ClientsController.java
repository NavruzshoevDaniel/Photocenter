package modules.clients.controller;

import lombok.extern.slf4j.Slf4j;
import modules.clients.entity.Client;
import modules.clients.repository.ClientRepository;
import modules.clients.repository.IClientsRepository;
import modules.clients.view.IClientsView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        } catch (SQLException throwables) {
            log.warn(throwables.getMessage(), throwables);
        }
    }

    @Override
    public void getClientsRows() {
        try {
            clientRepository.getAll()
                    .stream()
                    .map(this::mapToFieldsObjects)
                    .forEach(clientsView::addClientRow);
        } catch (SQLException throwables) {
            log.warn(throwables.getMessage(), throwables);
        }
    }

    private Object[] mapToFieldsObjects(Client client) {
        final List<Object> objects = new ArrayList<>();
        objects.add(client.getId());
        objects.add(client.getSecondName());
        objects.add(client.getFirstName());
        objects.add(client.getMiddleName());
        objects.add(client.isProfessional());
        objects.add(client.isDiscount());
        return objects.toArray();
    }
}
