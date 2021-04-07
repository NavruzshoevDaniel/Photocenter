package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Order;

import java.sql.SQLException;
import java.util.List;

public class OrderRepository implements Repository<Order> {
    @Override
    public void add(Order obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Order obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);

    }

    @Override
    public void update(Order obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);

    }

    @Override
    public List<Order> getAll() throws SQLException {
        return RepositoryUtil.getAll(Order.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Order.class);
    }
}
