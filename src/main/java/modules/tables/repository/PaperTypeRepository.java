package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.PaperType;

import java.sql.SQLException;
import java.util.List;

public class PaperTypeRepository implements Repository<PaperType> {
    @Override
    public void add(PaperType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(PaperType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(PaperType obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<PaperType> getAll() throws SQLException {
        return RepositoryUtil.getAll(PaperType.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(PaperType.class);
    }
}
