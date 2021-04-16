package commons.view.filters;

import commons.view.PropotionalRowPanel;

import javax.swing.*;
import java.util.List;

public class SearchTextFormFilter extends AbstractFormFilter {
    private JTextField searchTextField;

    public SearchTextFormFilter(String filterName, List<Integer> proportions) {
        super(filterName, proportions);
        filterNameLabel.setText(filterName);
    }

    @Override
    protected void configureUI(PropotionalRowPanel panel) {
        searchTextField = new JTextField();
        panel.initRow(filterNameLabel, searchTextField);
    }

    @Override
    protected Object getFilterParam() {
        return searchTextField.getText();
    }
}
