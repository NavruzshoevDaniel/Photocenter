package modules.auth.view;

import modules.auth.controller.IAuthController;
import modules.auth.view.formaterrs.IPAddressFormatter;
import modules.auth.view.formaterrs.PortFormatter;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class AuthView implements IAuthView {
    private static final String DEFAULT_BD_IP = "84.237.50.81";
    private static final String DEFAULT_BD_PORT = "1521";
    private static final String DEFAULT_BD_USERNAME = "18204_Navruzshoev";
    private static final String DEFAULT_BD_PASSWORD = "oracle";
    private static final int COLUMN_FIELD_SIZE = 25;

    private final JFrame frame;
    private final JPanel authViewPanel = new JPanel();
    private final JLabel ipLabel = new JLabel("IP");
    private final JLabel portLabel = new JLabel("Port");
    private final JLabel loginLabel = new JLabel("User");
    private final JLabel passwordLabel = new JLabel("Password");
    private final JTextField loginField = new JTextField(DEFAULT_BD_USERNAME);
    private final JTextField passwordField = new JPasswordField(DEFAULT_BD_PASSWORD);
    private final JButton connectButton = new JButton("Connect");
    private final JFormattedTextField ipField;
    private final JFormattedTextField portField;
    private IAuthController authController;

    public AuthView(JFrame frame) {
        this.frame = frame;
        this.ipField = new JFormattedTextField(new IPAddressFormatter());
        this.portField = new JFormattedTextField(new PortFormatter());
        ipField.setText(DEFAULT_BD_IP);
        portField.setText(DEFAULT_BD_PORT);
        setLayoutManager();
        setJComponentsSizes();
        configCredentialsPanels();
        configureButton();
        this.frame.setContentPane(authViewPanel);
    }

    private void configureButton() {
        connectButton.addActionListener(e ->
                authController.login(ipField.getText(), portField.getText(),
                        passwordField.getText(), loginField.getText()));
    }

    private void setJComponentsSizes() {
        Stream.of(loginField, passwordField, portField, ipField)
                .forEach(field -> field.setColumns(COLUMN_FIELD_SIZE));
        connectButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    private void configCredentialsPanels() {
        JPanel loginPanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel ipPanel = new JPanel();
        JPanel portPanel = new JPanel();

        loginPanel.add(loginLabel);
        loginPanel.add(loginField);

        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        ipPanel.add(ipLabel);
        ipPanel.add(ipField);

        portPanel.add(portLabel);
        portPanel.add(portField);

        authViewPanel.add(ipPanel);
        authViewPanel.add(portPanel);
        authViewPanel.add(loginPanel);
        authViewPanel.add(passwordPanel);
        authViewPanel.add(connectButton);
    }

    private void setLayoutManager() {
        authViewPanel.setLayout(new BoxLayout(authViewPanel, BoxLayout.Y_AXIS));
    }

    @Override
    public void showErrorConnectMessage(String message) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(authViewPanel.getRootPane(), message));
    }

    public void setAuthController(IAuthController authController) {
        this.authController = authController;
    }

    @Override
    public JFrame getJFrame() {
        return frame;
    }
}
