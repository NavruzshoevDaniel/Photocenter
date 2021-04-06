package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Firm;

import java.sql.SQLException;
import java.util.List;

public class FirmRepository implements Repository<Firm> {
    @Override
    public void add(Firm obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Firm obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Firm obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Firm> getAll() throws SQLException {
        return  RepositoryUtil.getAll(Firm.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return  RepositoryUtil.getColumns(Firm.class);
    }
}
