package modules.menu.view;

import modules.menu.controller.IMenuController;

import javax.swing.*;


public class MenuView implements IMenuView {
    private final JFrame frame;
    private final JPanel mainPanel = new JPanel();
    private final JButton queriesButton = new JButton("Queries");
    private final JButton clientsButton = new JButton("Tables");
    private IMenuController controller;

    public MenuView(JFrame frame) {
        this.frame = frame;
        addButtonsToPanel();
        addActionListeners();
        frame.setContentPane(mainPanel);
        frame.validate();
    }

    private void addActionListeners() {
        clientsButton.addActionListener(e -> SwingUtilities.invokeLater(() -> controller.routeToTables()));
    }

    private void addButtonsToPanel() {
        mainPanel.add(queriesButton);
        mainPanel.add(clientsButton);
    }

    public void setController(IMenuController controller) {
        this.controller = controller;
    }

    @Override
    public JFrame getJFrame() {
        return frame;
    }
}
