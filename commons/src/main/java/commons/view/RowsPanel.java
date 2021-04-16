package commons.view;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RowsPanel extends JPanel {
    private final List<PropotionalRowPanel> rowsPanel = new ArrayList<>();
    private final GridBagConstraints gridBagConstraints = new GridBagConstraints();


    public RowsPanel() {
        setLayout(new GridBagLayout());
    }

    public void addRow(PropotionalRowPanel propotionalRowPanel) {
        rowsPanel.add(propotionalRowPanel);
        add(propotionalRowPanel, gridBagConstraints);
        gridBagConstraints.gridy += 1;
    }
}
