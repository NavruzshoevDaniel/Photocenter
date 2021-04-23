package app;

import javax.swing.*;

public final class MainFrame {

    private MainFrame() {

    }

    private static JFrame mainFrame;

    public static void setMainFrame(JFrame frame) {
        mainFrame = frame;
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }
}
