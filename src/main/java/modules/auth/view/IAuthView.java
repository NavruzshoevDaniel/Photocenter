package modules.auth.view;

import modules.auth.controller.IAuthController;

import javax.swing.*;

public interface IAuthView {
    void showErrorConnectMessage(String message);

    void setAuthController(IAuthController controller);

    JFrame getJFrame();
}
