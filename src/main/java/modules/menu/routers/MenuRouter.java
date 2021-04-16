package modules.menu.routers;

import lombok.extern.slf4j.Slf4j;
import modules.querymenu.controllers.IQueriesMenuController;
import modules.querymenu.controllers.QueriesMenuController;
import modules.querymenu.entity.IQuarries;
import modules.querymenu.entity.Querries;
import modules.querymenu.view.IQueriesMenuView;
import modules.querymenu.view.QueriesMenuView;
import modules.tables.controller.ITablesController;
import modules.tables.controller.TablesController;
import modules.tables.view.ITablesView;
import modules.tables.view.TablesView;


import javax.swing.*;
import java.io.IOException;

@Slf4j
public class MenuRouter implements IMenuRoute {

    @Override
    public void routeToTables(JFrame frame) {
        ITablesView tablesView = new TablesView(frame);
        ITablesController tablesController = new TablesController(tablesView);
        tablesView.setController(tablesController);
        tablesView.init();
        log.info("Route to 'Table' module from 'Menu' module");
    }

    @Override
    public void routeToQuarries(JFrame frame) {
        try {
            IQuarries iQuarries = new Querries();
            IQueriesMenuView iQueriesMenuView = new QueriesMenuView(frame);
            IQueriesMenuController iQueriesMenuController = new QueriesMenuController(iQuarries, iQueriesMenuView);
            iQueriesMenuView.setController(iQueriesMenuController);
            iQueriesMenuView.init();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }
}
