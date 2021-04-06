package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.PrintDiscount;

import java.sql.SQLException;
import java.util.List;

public class PrintDiscountRepository implements Repository<PrintDiscount> {
    @Override
    public void add(PrintDiscount obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(PrintDiscount obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(PrintDiscount obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<PrintDiscount> getAll() throws SQLException {
        return RepositoryUtil.getAll(PrintDiscount.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(PrintDiscount.class);
    }
}
