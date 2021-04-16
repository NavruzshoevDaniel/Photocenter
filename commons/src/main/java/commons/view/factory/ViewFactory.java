package commons.view.factory;

import commons.sqlbuilder.SelectBuilder;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

@Slf4j
public abstract class ViewFactory {

    protected final Properties tablesProperty = new Properties();

    protected ViewFactory() {
        try (InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(getConfigPath().toString())) {
            tablesProperty.load(resourceAsStream);
        } catch (IOException e) {
            log.error(e.getMessage());
            throw new IllegalArgumentException("No config file:" + getConfigPath().toString());
        }
    }

    public JPanel createView(String tableName) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final String property = tablesProperty.getProperty(tableName);
        if (property == null) {
            throw new IllegalArgumentException("No such table:" + tableName);
        }
        final Class<?> tableClass = Class.forName(property);
        return (JPanel) tableClass.newInstance();
    }

    protected abstract Path getConfigPath();
}
