package app;

import modules.auth.controller.AuthController;
import modules.auth.controller.IAuthController;
import modules.auth.view.AuthView;
import modules.auth.view.IAuthView;


import javax.swing.*;

public class Main extends JFrame {
    private static final String PROJECT_NAME = "Photocenter";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame(PROJECT_NAME);
            mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainFrame.setLocationRelativeTo(null);
            IAuthView authView = new AuthView(mainFrame);
            IAuthController authController = new AuthController(authView);
            authView.setAuthController(authController);
            mainFrame.pack();
            mainFrame.setVisible(true);
        });
    }
}
