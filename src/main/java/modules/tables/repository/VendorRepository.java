package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Vendor;

import java.sql.SQLException;
import java.util.List;

public class VendorRepository implements Repository<Vendor> {
    @Override
    public void add(Vendor obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Vendor obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Vendor obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Vendor> getAll() throws SQLException {
        return RepositoryUtil.getAll(Vendor.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Vendor.class);
    }
}
