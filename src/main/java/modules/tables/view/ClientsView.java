package modules.tables.view;

import commons.view.EntryFormView;
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
    protected void initEntryForm(EntryFormView formPanel) {
        this.formPanel.addTextField("Second name");
        this.formPanel.addTextField("First name");
        this.formPanel.addTextField("Middle name");
        this.formPanel.addBooleanField("Is Professional");
        this.formPanel.addBooleanField("Discount");
    }
}
