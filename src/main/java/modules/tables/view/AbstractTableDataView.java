package modules.tables.view;

import commons.view.EntryFormView;
import lombok.extern.slf4j.Slf4j;
import modules.tables.controller.AbstractTableController;
import modules.tables.entity.TableData;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

@Slf4j
public abstract class AbstractTableDataView<T extends TableData> extends JPanel
        implements ITableView {
    private static final String ADDING_PANEL = "Card with adding form";
    private static final String TABLE_PANEL = "Card with table info";
    private static final int ID_COLUMN_INDEX = 0;

    private final JTable table = new JTable();
    private final JPanel cardPanel = new JPanel(new CardLayout());
    private final JPanel tableCard = new JPanel(new BorderLayout());
    private final JPanel addingCard = new JPanel(new BorderLayout());

    private final JButton createButton = new JButton("Создать");
    private final JButton cancelButton = new JButton("Отмена");
    private final JButton addButton = new JButton("Добавить");
    private final JButton removeButton = new JButton("Удалить");

    protected DefaultTableModel defaultTableModel;
    protected AbstractTableController<T> abstractTableController;
    private final TableModelListener updateListener;
    protected final EntryFormView formPanel = new EntryFormView(Arrays.asList(1, 2, 1));

    protected AbstractTableDataView() {
        defaultTableModel = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return getValueAt(0, columnIndex).getClass();
            }
        };
        updateListener = event -> {
            int rowIndex = event.getFirstRow();
            abstractTableController.updateRow(readAllColumns(rowIndex));
            updateRows();
        };
        configUI();
    }

    private void configUI() {
        setLayout(new BorderLayout());
        configTableCard();
        configAddingCard();
        cardPanel.add(tableCard, TABLE_PANEL);
        cardPanel.add(addingCard, ADDING_PANEL);
        add(cardPanel, BorderLayout.CENTER);
    }

    private void configAddingCard() {
        JScrollPane addingScrollPane = new JScrollPane();
        addingScrollPane.getViewport().add(formPanel.getPanelContent());
        addingCard.add(addingScrollPane, BorderLayout.CENTER);
        final JPanel bottomPanel = new JPanel(new GridLayout());
        cancelButton.addActionListener(e -> routeToTableForm());
        bottomPanel.add(cancelButton);
        bottomPanel.add(createButton);
        addingCard.add(bottomPanel, BorderLayout.SOUTH);
        initEntryForm(formPanel);
    }

    private void configTableCard() {
        table.getTableHeader().setBackground(Color.CYAN);
        table.getTableHeader().setReorderingAllowed(false);

        final JScrollPane tableScrollPane = new JScrollPane();
        tableScrollPane.getViewport().add(table);
        tableCard.add(tableScrollPane, BorderLayout.CENTER);
        final JPanel bottomPanel = new JPanel(new GridLayout());
        addButton.addActionListener(e -> routeToAddingForm());
        removeButton.addActionListener(e -> removeRow());
        bottomPanel.add(addButton);
        bottomPanel.add(removeButton);
        tableCard.add(bottomPanel, BorderLayout.SOUTH);
    }

    protected abstract void initEntryForm(EntryFormView formPanel);

    @Override
    public void init() {
        SwingUtilities.invokeLater(this::updateRows);
        table.setModel(defaultTableModel);
        createButton.addActionListener(e -> {
            final Map<String, Object> values = formPanel.getValues();
            values.put(table.getColumnName(ID_COLUMN_INDEX),
                    defaultTableModel.getRowCount() + 1);
            log.info(values.toString());
            abstractTableController.addNewData(values);
            routeToTableForm();
        });
    }

    public void removeRow() {
        log.info("{}", table.getSelectedRow());
        if (table.getSelectedRow() >= 0) {
            final int[] selectedRows = table.getSelectedRows();
            List<Map<String, Object>> listParameters = new ArrayList<>();
            log.info("Selected rows:{}", selectedRows);
            for (int selectedRow : selectedRows) {
                final Map<String, Object> stringObjectMap = readAllColumns(selectedRow);
                listParameters.add(stringObjectMap);
            }
            abstractTableController.deleteRows(listParameters);
            updateRows();
        }
    }

    private void updateRows() {
        log.info(defaultTableModel.toString());
        defaultTableModel.removeTableModelListener(updateListener);
        defaultTableModel.setRowCount(0);
        defaultTableModel.setColumnCount(0);
        abstractTableController.getColumnNames();
        abstractTableController.getRows();
        defaultTableModel.addTableModelListener(updateListener);
    }

    private void routeToAddingForm() {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, ADDING_PANEL);
    }

    private void routeToTableForm() {
        CardLayout cl = (CardLayout) (cardPanel.getLayout());
        cl.show(cardPanel, TABLE_PANEL);
        formPanel.clearInputData();
        updateRows();
    }

    @Override
    public void addRow(Object[] dataFields) {
        defaultTableModel.addRow(dataFields);
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
