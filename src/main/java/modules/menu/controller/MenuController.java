package modules.menu.controller;

import modules.menu.routers.IMenuRoute;
import modules.menu.routers.MenuRouter;
import modules.menu.view.IMenuView;


public class MenuController implements IMenuController {
    private final IMenuView view;
    private final IMenuRoute menuRoute;

    public MenuController(IMenuView view) {
        this.view = view;
        menuRoute= new MenuRouter();
    }

    @Override
    public void routeToTables() {
        menuRoute.routeToTables(view.getJFrame());
    }
}
