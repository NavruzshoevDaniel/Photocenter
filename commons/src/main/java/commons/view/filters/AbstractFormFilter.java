package commons.view.filters;

import commons.view.PropotionalRowPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractFormFilter implements FilterForm {
    private static final List<Integer> DEFAULT_PROPORTIONS = Arrays.asList(1, 2, 2);
    private final PropotionalRowPanel panel;
    protected final JLabel filterNameLabel = new JLabel();
    protected final JCheckBox checkBox = new JCheckBox();

    protected AbstractFormFilter(String filterName, List<Integer> proportions) {
        this.panel = new PropotionalRowPanel(proportions);
        filterNameLabel.setText(filterName);
        filterNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.initRow(checkBox, filterNameLabel, initFilterForm());
    }

    protected AbstractFormFilter(String filterName) {
        this(filterName, DEFAULT_PROPORTIONS);
    }

    /**
     * You must to initialize memory for all ui components in this method
     */
    protected abstract JComponent initFilterForm();

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public boolean isSelected() {
        return checkBox.isSelected();
    }

    public String getLabelName() {
        return filterNameLabel.getName();
    }

}
