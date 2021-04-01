package modules.tables.controller;


import lombok.extern.slf4j.Slf4j;
import modules.tables.router.ITablesRouter;
import modules.tables.router.TablesRouter;
import modules.tables.service.ITablesNamesService;
import modules.tables.service.TableFactory;
import modules.tables.service.TablesNamesService;
import modules.tables.view.AbstractTableDataView;
import modules.tables.view.ITablesView;

import java.util.Locale;

@Slf4j
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
    public void getTableNames() {
        tablesView.setTableColumns(tablesNamesService.getAllTablesNames());
    }

    @Override
    public void getTable(String selectedItem) {
        try {
            final AbstractTableDataView tableView = TableFactory.getInstance()
                    .createTableView(selectedItem.toLowerCase(Locale.ROOT));
            tableView.init();
            tablesView.setTable(tableView);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error(e.getMessage(),e);
        }
    }
}
