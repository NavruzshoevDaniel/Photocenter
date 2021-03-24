package modules.tables.view;

import lombok.extern.slf4j.Slf4j;
import modules.tables.controller.ITablesController;

import javax.swing.*;
import java.awt.*;

@Slf4j
public class TablesView implements ITablesView {
    private final JFrame frame;
    private final JPanel mainPanel = new JPanel(new BorderLayout());
    private final JScrollPane scrollPane = new JScrollPane();
    private final JButton addButton = new JButton("Add");
    private final JButton menuButton = new JButton("Menu");
    private final JComboBox<String> tableNames = new JComboBox<>();
    private final JTable table = new JTable();
    private ITablesController tablesController;

    public TablesView(JFrame frame) {
        this.frame = frame;
        configureUISettings();
    }

    private void configureUISettings() {
        JPanel navigationPanel = new JPanel(new GridBagLayout());
        configureNavigationPanel(navigationPanel);
        configureButtons();
        mainPanel.add(navigationPanel, BorderLayout.NORTH);
        scrollPane.add(table);
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        frame.setContentPane(mainPanel);
        frame.validate();
    }

    private void configureButtons() {
        menuButton.addActionListener(event -> {
            SwingUtilities.invokeLater(() -> tablesController.routeToMenu());
        });
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
    public void setController(ITablesController tablesController) {
        this.tablesController = tablesController;
    }

    @Override
    public JFrame getJFrame() {
        return frame;
    }
}
