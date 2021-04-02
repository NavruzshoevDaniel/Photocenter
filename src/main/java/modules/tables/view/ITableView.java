package modules.tables.view;

public interface ITableView {
    void init();

    void addRow(Object[] clients);

    void setColumnName(String columnsName);

    void showErrorMessage(String message);
}
