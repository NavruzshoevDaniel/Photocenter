package modules.tables.view;

import modules.tables.controller.ITablesController;

import javax.swing.*;
import java.util.List;

public interface ITablesView {

    void init();

    void setController(ITablesController tablesController);

    JFrame getJFrame();

    void setTableColumns(List<String> allTablesNames);

    void setTable(AbstractTableDataView tableView);
}
