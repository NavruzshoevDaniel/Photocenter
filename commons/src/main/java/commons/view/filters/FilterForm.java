package commons.view.filters;

import javax.swing.*;
import java.util.Map;

public interface FilterForm {

    JPanel getPanel();

    Map<String, Object> getValues();
}
