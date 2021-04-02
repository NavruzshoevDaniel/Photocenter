package modules.tables.controller;

import java.util.List;
import java.util.Map;

public interface IDataController {
    void getColumnNames();

    void getRows();

    void updateRow(Map<String, Object> parameters);

    void addNewData(Map<String, Object> parameters);

    void deleteRows(List<Map<String, Object>> listParameters);
}
