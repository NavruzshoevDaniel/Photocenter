package modules.tables.controller;

import javax.swing.*;
import java.util.List;

public interface ITablesController {

    void routeToMenu();

    void getTable(String tableName);

    List<String> getTablesNames();
}
