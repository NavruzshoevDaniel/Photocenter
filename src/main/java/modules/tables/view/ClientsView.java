package modules.tables.view;

import lombok.extern.slf4j.Slf4j;
import modules.tables.controller.ClientsController;
import modules.tables.entity.Client;


@Slf4j
public class ClientsView extends AbstractTableDataView<Client> {

    public ClientsView() {
        super();
        abstractTableController = new ClientsController(this);
    }

    @Override
    protected void initEntryForm() {
        formPanel.addTextField("Second name");
        formPanel.addTextField("First name");
        formPanel.addTextField("Middle name");
        formPanel.addBooleanField("Is Professional");
        formPanel.addBooleanField("Discount");
    }
}
