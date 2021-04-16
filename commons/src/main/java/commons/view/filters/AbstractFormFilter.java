package commons.view.filters;

import commons.view.PropotionalRowPanel;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractFormFilter implements FilterForm {
    private static final List<Integer> DEFAULT_PROPORTIONS = Arrays.asList(1, 1);
    private final PropotionalRowPanel panel;
    protected final JLabel filterNameLabel = new JLabel();
    protected final Map<String, Object> values = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    protected AbstractFormFilter(String filterName, List<Integer> proportions) {
        this.panel = new PropotionalRowPanel(proportions);
        filterNameLabel.setText(filterName);
        filterNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        configureUI(panel);
    }

    protected AbstractFormFilter(String filterName) {
        this.panel = new PropotionalRowPanel(DEFAULT_PROPORTIONS);
        filterNameLabel.setText(filterName);
        filterNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        configureUI(panel);
    }

    /**
     * You must to initialize memory for all ui components in this method
     */
    protected abstract void configureUI(PropotionalRowPanel panel);

    @Override
    public JPanel getPanel() {
        return panel;
    }

    @Override
    public Map<String, Object> getValues() {
        values.clear();
        values.put(filterNameLabel.getText(), getFilterParam());
        return values;
    }

    public String getLabelName() {
        return filterNameLabel.getName();
    }

    protected abstract Object getFilterParam();
}
