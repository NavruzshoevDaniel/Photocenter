package modules.querymenu.view;

import modules.querymenu.controllers.IQueriesMenuController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class QueriesMenuView implements IQueriesMenuView {
    private static final int CELL_HEIGHT = 40;
    private final JFrame frame;
    private final JPanel quarriesPanel = new JPanel(new BorderLayout());
    private final JButton backButton = new JButton("Back");
    private final DefaultListModel<String> listModel = new DefaultListModel<>();
    private final JList<String> quarries = new JList<>(listModel);
    private IQueriesMenuController controller;

    public QueriesMenuView(JFrame frame) {
        this.frame = frame;
        configUI();
        quarries.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                controller.routeToQuery(quarries.getSelectedValue());
            }
        });
        backButton.addActionListener(e -> controller.routeToMenu());
    }

    private void configUI() {
        quarries.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        configureCellProperties();
        quarriesPanel.add(backButton, BorderLayout.SOUTH);
        quarriesPanel.add(quarries, BorderLayout.CENTER);
        frame.setContentPane(quarriesPanel);
        frame.validate();
    }

    private void configureCellProperties() {
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) quarries.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        quarries.setFixedCellHeight(CELL_HEIGHT);
    }

    @Override
    public void init() {
        controller.init();
    }

    @Override
    public void addQuarriesList(List<String> quarriesNames) {
        quarriesNames.forEach(listModel::addElement);
    }

    @Override
    public void setController(IQueriesMenuController controller) {
        this.controller = controller;
    }

    @Override
    public JFrame getJFrame() {
        return frame;
    }

}
