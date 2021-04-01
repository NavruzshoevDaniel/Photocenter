package modules.clients.view;

import lombok.extern.slf4j.Slf4j;
import modules.clients.controller.ClientsController;
import modules.clients.controller.IClientsController;
import modules.tables.view.AbstractTableDataView;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

@Slf4j
public class ClientsView extends AbstractTableDataView implements IClientsView {
    private final DefaultTableModel defaultTableModel = new DefaultTableModel();
    private IClientsController clientsController;

    public ClientsView(IClientsController clientsController) {
        this.clientsController = clientsController;
    }

    public ClientsView() {
        this.clientsController = new ClientsController(this);
        getTableHeader().setBackground(Color.CYAN);
    }

    @Override
    public void init() {
        SwingUtilities.invokeLater(() -> {
            setModel(defaultTableModel);
            clientsController.getColumnNames();
            clientsController.getClientsRows();
        });
    }

    @Override
    public void addClientRow(Object[] clientsFields) {
        defaultTableModel.addRow(clientsFields);
    }


    @Override
    public void setColumnName(String columnsName) {
        defaultTableModel.addColumn(columnsName);
    }
}
