package modules.clients.view;

public interface IClientsView {
    void init();

    void addClientRow(Object[] clients);

    void setColumnName(String columnsName);

    void showErrorMessage(String message);
}
