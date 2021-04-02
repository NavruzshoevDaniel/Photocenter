package modules.tables.view;

import javax.swing.*;

public abstract class AbstractTableDataView extends JPanel{
    public abstract void init();

    public abstract void addNewRow();

    public abstract void removeRow();
}
