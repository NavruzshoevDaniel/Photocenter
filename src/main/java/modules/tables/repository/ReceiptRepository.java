package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Receipt;

import java.sql.SQLException;
import java.util.List;

public class ReceiptRepository implements Repository<Receipt> {
    @Override
    public void add(Receipt obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Receipt obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Receipt obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Receipt> getAll() throws SQLException {
        return RepositoryUtil.getAll(Receipt.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Receipt.class);
    }
}
