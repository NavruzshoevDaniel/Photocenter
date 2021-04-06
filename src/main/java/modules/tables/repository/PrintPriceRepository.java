package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.PrintPrice;

import java.sql.SQLException;
import java.util.List;

public class PrintPriceRepository implements Repository<PrintPrice> {
    @Override
    public void add(PrintPrice obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(PrintPrice obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(PrintPrice obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<PrintPrice> getAll() throws SQLException {
        return RepositoryUtil.getAll(PrintPrice.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(PrintPrice.class);
    }
}
