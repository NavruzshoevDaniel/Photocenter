package modules.tables.controller;


import modules.tables.router.ITablesRouter;
import modules.tables.router.TablesRouter;
import modules.tables.service.ITablesNamesService;
import modules.tables.service.TablesNamesService;
import modules.tables.view.ITablesView;

import java.util.List;

public class TablesController implements ITablesController {
    private final ITablesView tablesView;
    private final ITablesRouter tablesRouter = new TablesRouter();
    private final ITablesNamesService tablesNamesService = new TablesNamesService();

    public TablesController(ITablesView tablesView) {
        this.tablesView = tablesView;
    }

    @Override
    public void routeToMenu() {
        tablesRouter.routeToMenu(tablesView.getJFrame());
    }

    @Override
    public void getTable(String tableName) {

    }

    @Override
    public List<String> getTablesNames() {
        return tablesNamesService.getAllTablesNames();
    }
}
