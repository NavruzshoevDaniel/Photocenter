package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.OutletType;

import java.sql.SQLException;
import java.util.List;

public class OutletTypeRepository implements Repository<OutletType> {
    @Override
    public void add(OutletType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(OutletType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(OutletType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<OutletType> getAll() throws SQLException {
        return RepositoryUtil.getAll(OutletType.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(OutletType.class);
    }
}
