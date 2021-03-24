package modules.menu.controller;

import modules.menu.routers.IMenuRoute;
import modules.menu.routers.MenuRouter;
import modules.menu.view.IMenuView;

import java.sql.Connection;

public class MenuController implements IMenuController {
    private final Connection connection;
    private final IMenuView view;
    private final IMenuRoute menuRoute;

    public MenuController(Connection connection, IMenuView view) {
        this.connection = connection;
        this.view = view;
        menuRoute= new MenuRouter();
    }

    @Override
    public void routeToTables() {

    }
}
