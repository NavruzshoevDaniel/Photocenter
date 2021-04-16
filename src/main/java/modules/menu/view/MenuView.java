package modules.menu.view;

import lombok.extern.slf4j.Slf4j;
import modules.menu.controller.IMenuController;
import modules.menu.services.InitializerService;
import modules.menu.services.InitializerServiceImpl;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;

@Slf4j
public class MenuView implements IMenuView {
    private static final int ROWS_AMOUNT  = 3;
    private static final int COLUMNS_AMOUNT = 1;
    private final JFrame frame;
    private final JPanel mainPanel = new JPanel(new GridLayout(ROWS_AMOUNT,COLUMNS_AMOUNT));
    private final JButton queriesButton = new JButton("Queries");
    private final JButton tablesButton = new JButton("Tables");
    private final JButton initButton = new JButton("Init data");
    private final InitializerService initializerService = new InitializerServiceImpl();
    private IMenuController controller;

    public MenuView(JFrame frame) {
        this.frame = frame;
        addButtonsToPanel();
        addActionListeners();
        frame.setContentPane(mainPanel);
        frame.validate();
    }

    private void addActionListeners() {
        tablesButton.addActionListener(e  -> controller.routeToTables());
        initButton.addActionListener(e -> {
            try {
                initializerService.initPhotocenterData();
            } catch (SQLException | IOException | URISyntaxException ex) {
                log.warn(ex.getMessage(), ex);
                JOptionPane.showMessageDialog(mainPanel.getRootPane(), ex.getMessage());
            }
        });
        queriesButton.addActionListener(e-> controller.routeToQueries());
    }

    private void addButtonsToPanel() {
        mainPanel.add(queriesButton);
        mainPanel.add(tablesButton);
        mainPanel.add(initButton);
    }

    public void setController(IMenuController controller) {
        this.controller = controller;
    }

    @Override
    public JFrame getJFrame() {
        return frame;
    }
}
