package commons.view.factory;

import lombok.extern.slf4j.Slf4j;

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

    protected abstract Path getConfigPath();
}
