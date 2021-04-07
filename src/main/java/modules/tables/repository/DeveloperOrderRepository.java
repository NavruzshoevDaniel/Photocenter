package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.DeveloperOrder;

import java.sql.SQLException;
import java.util.List;

public class DeveloperOrderRepository implements Repository<DeveloperOrder> {
    @Override
    public void add(DeveloperOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(DeveloperOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(DeveloperOrder obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<DeveloperOrder> getAll() throws SQLException {
        return RepositoryUtil.getAll(DeveloperOrder.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(DeveloperOrder.class);
    }
}
