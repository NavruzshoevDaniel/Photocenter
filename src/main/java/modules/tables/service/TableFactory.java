package modules.tables.service;

import lombok.extern.slf4j.Slf4j;
import modules.tables.view.AbstractTableDataView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class TableFactory {
    private static final String CONFIG_TABLE_FILE = "/tables.properties";

    private final Properties tablesProperty = new Properties();

    private TableFactory() {
        try (InputStream resourceAsStream = TableFactory.class.getResourceAsStream(CONFIG_TABLE_FILE)) {
            tablesProperty.load(resourceAsStream);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("No config file:" + CONFIG_TABLE_FILE);
        }

    }

    public static TableFactory getInstance() {
        return Handle.INSTANCE;
    }

    public AbstractTableDataView createTableView(String tableName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final String property = tablesProperty.getProperty(tableName);
        if (property == null) {
            throw new IllegalArgumentException("No such table:" + tableName);
        }
        final Class<?> tableClass = Class.forName(property);
        return (AbstractTableDataView) tableClass.newInstance();
    }

    private static class Handle {
        private static final TableFactory INSTANCE = new TableFactory();
    }
}
