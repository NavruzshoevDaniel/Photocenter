package modules.tables.view;

import modules.tables.controller.ITablesController;

import javax.swing.*;

public interface ITablesView {
    void setController(ITablesController tablesController);

    JFrame getJFrame();
}
