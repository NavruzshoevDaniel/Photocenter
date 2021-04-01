package modules.menu.routers;

import lombok.extern.slf4j.Slf4j;
import modules.tables.controller.ITablesController;
import modules.tables.controller.TablesController;
import modules.tables.view.ITablesView;
import modules.tables.view.TablesView;


import javax.swing.*;

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
}
