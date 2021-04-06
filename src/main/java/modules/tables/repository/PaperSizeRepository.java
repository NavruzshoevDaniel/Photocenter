package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.PaperSize;

import java.sql.SQLException;
import java.util.List;

public class PaperSizeRepository implements Repository<PaperSize> {
    @Override
    public void add(PaperSize obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(PaperSize obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(PaperSize obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<PaperSize> getAll() throws SQLException {
        return  RepositoryUtil.getAll(PaperSize.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(PaperSize.class);
    }
}
