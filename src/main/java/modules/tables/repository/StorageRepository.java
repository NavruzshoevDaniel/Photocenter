package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Storage;

import java.sql.SQLException;
import java.util.List;

public class StorageRepository implements Repository<Storage> {
    @Override
    public void add(Storage obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Storage obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);

    }

    @Override
    public void update(Storage obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Storage> getAll() throws SQLException {
        return RepositoryUtil.getAll(Storage.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Storage.class);
    }
}
