package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Item;

import java.sql.SQLException;
import java.util.List;

public class ItemRepository implements Repository<Item> {
    @Override
    public void add(Item obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Item obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Item obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Item> getAll() throws SQLException {
        return RepositoryUtil.getAll(Item.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Item.class);
    }
}
