package commons.view.filters;

import commons.view.PropotionalRowPanel;

import javax.swing.*;
import java.util.List;

public class NumberFormFilter extends AbstractFormFilter {
    private JSpinner numberSpinner;

    public NumberFormFilter(String filterName,
                            List<Integer> proportions,
                            NumberSpinnerParameters parameters) {
        super(filterName, proportions);
        configureModels(parameters);
    }

    public NumberFormFilter(String filterName, NumberSpinnerParameters parameters) {
        super(filterName);
        configureModels(parameters);
    }

    private void configureModels(NumberSpinnerParameters parameters) {
        SpinnerNumberModel minSpinnerModel = new SpinnerNumberModel(
                parameters.getInitValue(),
                parameters.getMin(),
                parameters.getMax(),
                parameters.getStep());
        numberSpinner.setModel(minSpinnerModel);
    }

    @Override
    protected void configureUI(PropotionalRowPanel panel) {
        numberSpinner = new JSpinner();
        panel.initRow(filterNameLabel, numberSpinner);
    }

    @Override
    protected Object getFilterParam() {
        return numberSpinner.getValue();
    }
}
