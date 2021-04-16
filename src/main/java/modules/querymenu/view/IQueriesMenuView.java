package modules.querymenu.view;

import modules.querymenu.controllers.IQueriesMenuController;

import javax.swing.*;
import java.util.List;

public interface IQueriesMenuView {
    void init();

    void addQuarriesList(List<String> quarriesNames);

    void setController(IQueriesMenuController controller);

    JFrame getJFrame();
}
