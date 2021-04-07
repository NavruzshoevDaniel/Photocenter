package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.PrintOrder;

import java.sql.SQLException;
import java.util.List;

public class PrintOrderRepository implements Repository<PrintOrder> {
    @Override
    public void add(PrintOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(PrintOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(PrintOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<PrintOrder> getAll() throws SQLException {
        return RepositoryUtil.getAll(PrintOrder.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(PrintOrder.class);
    }
}
