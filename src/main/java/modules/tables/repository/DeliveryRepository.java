package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import modules.tables.entity.Delivery;

import java.sql.SQLException;
import java.util.List;

public class DeliveryRepository implements Repository<Delivery> {
    @Override
    public void add(Delivery obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(Delivery obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(Delivery obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.update(obj);
    }

    @Override
    public List<Delivery> getAll() throws SQLException {
        return  RepositoryUtil.getAll(Delivery.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(Delivery.class);
    }
}
