package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Outlet;

import java.sql.SQLException;
import java.util.List;

public class OutletRepository implements Repository<Outlet> {
    @Override
    public void add(Outlet obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Outlet obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Outlet obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Outlet> getAll() throws SQLException {
        return RepositoryUtil.getAll(Outlet.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Outlet.class);
    }
}
