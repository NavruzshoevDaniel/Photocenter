package modules.clients.view;

import commons.view.EntryFormView;
import lombok.extern.slf4j.Slf4j;
import modules.clients.controller.ClientsController;
import modules.clients.controller.IClientsController;
import modules.tables.view.AbstractTableDataView;


import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

@Slf4j
public class ClientsView extends AbstractTableDataView implements IClientsView {
    private final JTable table = new JTable();
    private final JScrollPane scrollPane = new JScrollPane();
    private final DefaultTableModel defaultTableModel = new DefaultTableModel();
    private final JButton createButton = new JButton("Create");
    private final JButton backButton = new JButton("Cancel");
    private final JPanel bottomPanel = new JPanel(new GridLayout());
    private EntryFormView formPanel = new EntryFormView(Arrays.asList(1, 2, 1));
    private IClientsController clientsController;

    private final TableModelListener updateListener = event -> {
        int rowIndex = event.getFirstRow();
        clientsController.updateRow(readAllColumns(rowIndex));
        updateRows();
    };

    public ClientsView() {
        this.clientsController = new ClientsController(this);
        configUI();
    }

    private void configUI() {
        setLayout(new BorderLayout());
        table.getTableHeader().setBackground(Color.CYAN);
        table.setModel(defaultTableModel);
        table.getTableHeader().setReorderingAllowed(false);

        scrollPane.getViewport().add(table);
        bottomPanel.add(backButton);
        bottomPanel.add(createButton);
        bottomPanel.setVisible(false);

        add(bottomPanel, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);

        initEntryForm();
    }

    private void initEntryForm() {
        formPanel.addTextField("Second name");
        formPanel.addTextField("First name");
        formPanel.addTextField("Middle name");
        formPanel.addBooleanField("Is Professional");
        formPanel.addBooleanField("Discount");
    }

    @Override
    public void init() {
        SwingUtilities.invokeLater(this::updateRows);
        backButton.addActionListener(e -> routeToTableForm());
        createButton.addActionListener(e -> {
            final Map<String, Object> values = formPanel.getValues();
            values.put("Id", defaultTableModel.getRowCount() + 1);
            log.info(values.toString());
            clientsController.addNewClient(values);
            routeToTableForm();
        });
    }

    @Override
    public void addNewRow() {
        log.info("Try to add");
        routeToAddingForm();
    }

    @Override
    public void removeRow() {
        if (table.getSelectedRow() > 0) {
            final int[] selectedRows = table.getSelectedRows();
            List<Map<String, Object>> listParameters = new ArrayList<>();
            for (int i = 0; i < selectedRows.length; i++) {
                listParameters.add(readAllColumns(i));
            }
            clientsController.deleteRows(listParameters);
        }
    }

    private void updateRows() {
        defaultTableModel.removeTableModelListener(updateListener);
        defaultTableModel.setRowCount(0);
        defaultTableModel.setColumnCount(0);
        clientsController.getColumnNames();
        clientsController.getClientsRows();
        defaultTableModel.addTableModelListener(updateListener);
    }

    private void routeToAddingForm() {
        scrollPane.getViewport().remove(table);
        bottomPanel.setVisible(true);
        scrollPane.getViewport().add(formPanel.getPanelContent(), BorderLayout.CENTER);
    }

    private void routeToTableForm() {
        scrollPane.getViewport().removeAll();
        bottomPanel.setVisible(false);
        scrollPane.getViewport().add(table, BorderLayout.CENTER);
        formPanel.clearInputData();
        updateRows();
    }


    @Override
    public void addClientRow(Object[] clientsFields) {
        defaultTableModel.addRow(clientsFields);
    }


    @Override
    public void setColumnName(String columnsName) {
        defaultTableModel.addColumn(columnsName);
    }

    @Override
    public void showErrorMessage(String message) {
        SwingUtilities.invokeLater(() ->
                JOptionPane.showMessageDialog(this.getRootPane(), message));
    }

    private Map<String, Object> readAllColumns(int rowIndex) {
        Map<String, Object> parameters = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        for (int i = 0; i < defaultTableModel.getColumnCount(); i++) {
            parameters.put(defaultTableModel.getColumnName(i).toLowerCase(Locale.ROOT),
                    defaultTableModel.getValueAt(rowIndex, i));
        }
        return parameters;
    }

}
