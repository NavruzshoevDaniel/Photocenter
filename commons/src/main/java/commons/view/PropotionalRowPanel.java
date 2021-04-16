package commons.view;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class PropotionalRowPanel extends JPanel {
    private final List<Integer> columnsProportions;
    private static final int CONSTRAINT_HEIGHT = 10;

    private final GridBagConstraints constraint = new GridBagConstraints();

    public PropotionalRowPanel(List<Integer> columnsProportions) {
        this.columnsProportions = columnsProportions;
        init();
    }

    public PropotionalRowPanel(List<Integer> columnsProportions, List<JComponent> columns) {
        this(columnsProportions);
        initRow(columns);
    }

    public PropotionalRowPanel(List<Integer> columnsProportions, JComponent... columns) {
        this.columnsProportions = columnsProportions;
        init();
        initRow(columns);
    }

    private void init() {
        setLayout(new GridBagLayout());
        constraint.fill = GridBagConstraints.HORIZONTAL;
        constraint.gridy = 0;
        constraint.weighty = CONSTRAINT_HEIGHT;
    }

    public void initRow(List<JComponent> columns) {
        for (int i = 0; i < columnsProportions.size(); i++) {
            constraint.gridx = i;
            constraint.weightx = columnsProportions.get(i);
            try {
                add(columns.get(i), constraint);
            } catch (IndexOutOfBoundsException e) {
                add(new JPanel(), constraint);
            }
        }
    }

    public void initRow(JComponent... columns) {
        initRow(Arrays.asList(columns));
    }

}
