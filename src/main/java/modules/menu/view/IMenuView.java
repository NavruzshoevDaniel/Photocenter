package modules.menu.view;

import modules.menu.controller.IMenuController;

import javax.swing.*;

public interface IMenuView {
    void setController(IMenuController controller);

    JFrame getJFrame();
}
