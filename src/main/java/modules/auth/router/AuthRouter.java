package modules.auth.router;

import modules.menu.controller.IMenuController;
import modules.menu.controller.MenuController;
import modules.menu.view.IMenuView;
import modules.menu.view.MenuView;

import javax.swing.*;
import java.sql.Connection;

public class AuthRouter implements IAuthRouter {

    @Override
    public void route(Connection connection, JFrame frame) {
        IMenuView menuView = new MenuView(frame);
        IMenuController menuController = new MenuController(connection, menuView);
        menuView.setController(menuController);
    }
}
