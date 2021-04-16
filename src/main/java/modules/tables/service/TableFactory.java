package modules.tables.service;

import commons.view.factory.ViewFactory;
import lombok.extern.slf4j.Slf4j;
import modules.tables.view.AbstractTableDataView;

import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
public class TableFactory extends ViewFactory {
    private static final Path CONFIG_TABLE_FILE = Paths.get("tables.properties");

    private TableFactory() {
        super();
    }

    @Override
    protected Path getConfigPath() {
        return CONFIG_TABLE_FILE;
    }

    public static TableFactory getInstance() {
        return Handle.INSTANCE;
    }

    public AbstractTableDataView<?> createView(String tableName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final String property = tablesProperty.getProperty(tableName);
        if (property == null) {
            throw new IllegalArgumentException("No such table:" + tableName);
        }
        final Class<?> tableClass = Class.forName(property);
        return (AbstractTableDataView<?>) tableClass.newInstance();
    }

    private static class Handle {
        private static final TableFactory INSTANCE = new TableFactory();
    }
}
