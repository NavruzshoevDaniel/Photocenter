package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.DeveloperPrice;

import java.sql.SQLException;
import java.util.List;

public class DeveloperPriceRepository implements Repository<DeveloperPrice> {
    @Override
    public void add(DeveloperPrice obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(DeveloperPrice obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(DeveloperPrice obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<DeveloperPrice> getAll() throws SQLException {
        return RepositoryUtil.getAll(DeveloperPrice.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(DeveloperPrice.class);
    }
}
