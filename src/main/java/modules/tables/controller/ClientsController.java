package modules.tables.controller;

import lombok.extern.slf4j.Slf4j;
import modules.tables.entity.Client;

import modules.tables.mapper.Mapper;
import modules.tables.repository.ClientRepository;
import modules.tables.view.AbstractTableDataView;

import java.util.Map;

@Slf4j
public class ClientsController extends AbstractTableController<Client> implements IDataController {
    public ClientsController(AbstractTableDataView<Client> view) {
        super(view);
        repository = new ClientRepository();
    }

    @Override
    protected Client createData(Map<String, Object> parameters) {
        return new Client(new Mapper(parameters));
    }
}
