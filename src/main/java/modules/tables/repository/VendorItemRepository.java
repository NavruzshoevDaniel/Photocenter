package modules.tables.repository;

import commons.jdbc.jpa.util.RepositoryUtil;
import commons.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import modules.tables.entity.VendorItem;

import java.sql.SQLException;
import java.util.List;

@Slf4j
public class VendorItemRepository implements Repository<VendorItem> {
    @Override
    public void add(VendorItem obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.create(obj);
    }

    @Override
    public void remove(VendorItem obj) throws SQLException, IllegalAccessException {
        RepositoryUtil.deleteById(obj);
    }

    @Override
    public void update(VendorItem obj) throws SQLException, IllegalAccessException {
        log.info(obj.toString());
        RepositoryUtil.update(obj);
    }

    @Override
    public List<VendorItem> getAll() throws SQLException {
        return RepositoryUtil.getAll(VendorItem.class);
    }

    @Override
    public List<String> getColumns() throws SQLException {
        return RepositoryUtil.getColumns(VendorItem.class);
    }
}
