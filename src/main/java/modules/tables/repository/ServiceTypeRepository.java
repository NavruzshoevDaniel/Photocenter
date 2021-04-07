package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.ServiceType;

import java.sql.SQLException;
import java.util.List;

public class ServiceTypeRepository implements Repository<ServiceType> {
    @Override
    public void add(ServiceType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(ServiceType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(ServiceType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<ServiceType> getAll() throws SQLException {
        return RepositoryUtil.getAll(ServiceType.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(ServiceType.class);
    }
}
