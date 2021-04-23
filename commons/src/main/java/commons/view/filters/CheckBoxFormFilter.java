package commons.view.filters;


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
    protected JComponent initFilterForm() {
        checkBox = new JCheckBox();
        return checkBox;
    }

    @Override
    public Object getValue() {
        return checkBox.isSelected();
    }
}
