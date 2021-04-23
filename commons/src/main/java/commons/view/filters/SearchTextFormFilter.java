package commons.view.filters;


import javax.swing.*;
import java.util.List;

public class SearchTextFormFilter extends AbstractFormFilter {
    private JTextField searchTextField;

    public SearchTextFormFilter(String filterName, List<Integer> proportions) {
        super(filterName, proportions);
        filterNameLabel.setText(filterName);
    }

    @Override
    protected JComponent initFilterForm() {
        searchTextField = new JTextField();
        return searchTextField;
    }

    @Override
    public Object getValue() {
        return searchTextField.getText().trim();
    }
}
