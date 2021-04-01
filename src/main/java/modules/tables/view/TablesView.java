package modules.tables.view;

import lombok.extern.slf4j.Slf4j;
import modules.tables.controller.ITablesController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public class TablesView implements ITablesView {
    private final JFrame frame;
    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JScrollPane scrollPane = new JScrollPane();
    private final JButton addButton = new JButton("Add");
    private final JButton menuButton = new JButton("Menu");
    private final JComboBox<String> tableNames = new JComboBox<>();
    private final DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();
    private ITablesController tablesController;

    public TablesView(JFrame frame) {
        this.frame = frame;
        configureUISettings();
    }

    private void configureUISettings() {
        JPanel navigationPanel = new JPanel(new GridBagLayout());
        configureComboBox();
        configureNavigationPanel(navigationPanel);
        configureButtons();
        mainPanel.add(navigationPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(mainPanel);
        frame.validate();
    }

    private void configureComboBox() {
        tableNames.setModel(comboBoxModel);
    }

    private void configureButtons() {
        menuButton.addActionListener(event -> SwingUtilities.invokeLater(
                () -> tablesController.routeToMenu()));
    }

    private void configureNavigationPanel(JPanel navigationPanel) {
        GridBagConstraints navigationConstraints = new GridBagConstraints();
        navigationConstraints.gridx = 0;
        navigationConstraints.gridy = 0;
        navigationConstraints.weightx = 1.0f;
        navigationConstraints.fill = GridBagConstraints.HORIZONTAL;

        navigationPanel.add(menuButton, navigationConstraints);
        navigationConstraints.gridx = 1;
        navigationPanel.add(tableNames, navigationConstraints);
        navigationConstraints.gridx = 2;
        navigationPanel.add(addButton, navigationConstraints);
    }

    @Override
    public void init() {
        tablesController.getTableNames();
    }

    @Override
    public void setController(ITablesController tablesController) {
        this.tablesController = tablesController;
    }

    @Override
    public JFrame getJFrame() {
        return frame;
    }

    @Override
    public void setTableColumns(List<String> allTablesNames) {
        SwingUtilities.invokeLater(() -> {
            allTablesNames.forEach(comboBoxModel::addElement);
            final String selectedItem = (String) comboBoxModel.getSelectedItem();
            log.info(selectedItem);
            tablesController.getTable(selectedItem);
        });
    }

    @Override
    public void setTable(AbstractTableDataView tableView) {
        scrollPane.getViewport().add(tableView);
    }
}
