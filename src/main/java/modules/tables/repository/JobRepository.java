package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Job;

import java.sql.SQLException;
import java.util.List;

public class JobRepository implements Repository<Job> {
    @Override
    public void add(Job obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Job obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Job obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Job> getAll() throws SQLException {
        return RepositoryUtil.getAll(Job.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Job.class);
    }
}
