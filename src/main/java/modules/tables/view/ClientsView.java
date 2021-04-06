package modules.tables.view;

import lombok.extern.slf4j.Slf4j;
import modules.tables.controller.ClientsController;
import modules.tables.entity.Client;

import javax.swing.table.DefaultTableModel;


@Slf4j
public class ClientsView extends AbstractTableDataView<Client> {

    public ClientsView() {
        super();
        abstractTableController = new ClientsController(this);
        this.defaultTableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex==4||columnIndex==5) {
                    return Boolean.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
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
