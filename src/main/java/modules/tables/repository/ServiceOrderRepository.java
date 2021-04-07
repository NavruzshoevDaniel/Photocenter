package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.ServiceOrder;

import java.sql.SQLException;
import java.util.List;

public class ServiceOrderRepository implements Repository<ServiceOrder> {
    @Override
    public void add(ServiceOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(ServiceOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(ServiceOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<ServiceOrder> getAll() throws SQLException {
        return RepositoryUtil.getAll(ServiceOrder.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(ServiceOrder.class);
    }
}
