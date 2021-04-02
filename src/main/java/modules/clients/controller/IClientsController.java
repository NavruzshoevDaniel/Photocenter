package modules.clients.controller;

import java.util.List;
import java.util.Map;

public interface IClientsController {
    void getColumnNames();

    void getClientsRows();

    void updateRow(Map<String, Object> parameters);

    void addNewClient(Map<String, Object> parameters);

    void deleteRows(List<Map<String, Object>> listParameters);
}
