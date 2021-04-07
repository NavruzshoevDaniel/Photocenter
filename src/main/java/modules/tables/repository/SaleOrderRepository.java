package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.SaleOrder;

import java.sql.SQLException;
import java.util.List;

public class SaleOrderRepository implements Repository<SaleOrder> {
    @Override
    public void add(SaleOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(SaleOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(SaleOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<SaleOrder> getAll() throws SQLException {
        return RepositoryUtil.getAll(SaleOrder.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(SaleOrder.class);
    }
}
