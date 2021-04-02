package commons.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {

    void add(T obj) throws SQLException, IllegalAccessException;

    void remove(T obj) throws SQLException, IllegalAccessException;

    void update(T obj) throws SQLException, IllegalAccessException;

    List<T> getAll() throws SQLException;
}
