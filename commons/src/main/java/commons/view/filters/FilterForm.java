package commons.view.filters;


import javax.swing.*;

public interface FilterForm {

    JPanel getPanel();

    Object getValue();

    boolean isSelected();
}
