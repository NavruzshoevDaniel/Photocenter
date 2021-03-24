package modules.tables.router;

import lombok.extern.slf4j.Slf4j;
import modules.menu.controller.IMenuController;
import modules.menu.controller.MenuController;
import modules.menu.view.IMenuView;
import modules.menu.view.MenuView;

import javax.swing.*;
@Slf4j
public class TablesRouter implements ITablesRouter {
    @Override
    public void routeToMenu(JFrame frame) {
        IMenuView menuView = new MenuView(frame);
        IMenuController menuController = new MenuController(menuView);
        menuView.setController(menuController);
        log.info("Route to 'Menu' module from 'Tables' module");
    }
}
