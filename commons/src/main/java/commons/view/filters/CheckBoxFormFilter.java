package commons.view.filters;

import commons.view.PropotionalRowPanel;

import javax.swing.*;

import java.util.List;

public class CheckBoxFormFilter extends AbstractFormFilter {
    private JCheckBox checkBox;

    public CheckBoxFormFilter(String filterName, List<Integer> proportions) {
        super(filterName, proportions);
    }

    public CheckBoxFormFilter(String filterName) {
        super(filterName);
    }

    @Override
    protected void configureUI(PropotionalRowPanel panel) {
        checkBox = new JCheckBox();
        panel.initRow(filterNameLabel, checkBox);
    }

    @Override
    protected Object getFilterParam() {
        return checkBox.isSelected();
    }
}
