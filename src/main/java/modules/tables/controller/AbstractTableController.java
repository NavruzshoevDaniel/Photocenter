package modules.tables.controller;

import commons.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import modules.tables.entity.TableData;
import modules.tables.view.AbstractTableDataView;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Slf4j
public abstract class AbstractTableController<T extends TableData> implements IDataController {
    private final AbstractTableDataView<T> tableDataView;
    protected Repository<T> repository;

    protected AbstractTableController(AbstractTableDataView<T> view) {
        this.tableDataView = view;
    }

    @Override
    public void getColumnNames() {
        try {
            repository.getColumns()
                    .stream()
                    .map(column -> column.replace("_", " "))
                    .forEach(tableDataView::setColumnName);
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
            tableDataView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void getRows() {
        try {
            repository.getAll()
                    .stream()
                    .map(this::mapToFieldsObjects)
                    .forEach(tableDataView::addRow);
        } catch (SQLException e) {
            log.warn(e.getMessage(), e);
            tableDataView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void updateRow(Map<String, Object> parameters) {

        try {
            repository.update(createData(parameters));
        } catch (SQLException | IllegalAccessException | ClassCastException e) {
            log.warn(e.getMessage(), e);
            tableDataView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void addNewData(Map<String, Object> parameters) {
        try {
            repository.add(createData(parameters));
        } catch (SQLException | IllegalAccessException | ClassCastException e) {
            log.warn(e.getMessage(), e);
            tableDataView.showErrorMessage(e.getMessage());
        }
    }

    @Override
    public void deleteRows(List<Map<String, Object>> listParameters) {
        for (Map<String, Object> parameters : listParameters) {
            try {
                repository.remove(createData(parameters));
            } catch (SQLException | IllegalAccessException e) {
                log.warn(e.getMessage(), e);
                tableDataView.showErrorMessage(e.getMessage());
            }
        }
    }

    private Object[] mapToFieldsObjects(T data) {
        return data.toObjects().toArray();
    }

    protected abstract T createData(Map<String, Object> parameters);
}
