package modules.quarries.views.gui;

import javax.swing.table.DefaultTableModel;

public class UnmodifiableModel extends DefaultTableModel {
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
