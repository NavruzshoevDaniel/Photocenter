package commons.service;

import java.sql.SQLException;
import java.util.List;

public interface DataService<T> {
    T getById(long id);

    void add(T obj);

    void remove(T obj);

    void update(T obj);

    List<T> getAll() throws SQLException;
}
