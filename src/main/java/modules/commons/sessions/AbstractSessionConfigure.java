package modules.commons.sessions;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

@Slf4j
public abstract class AbstractSessionConfigure {
    private static final String URL_KEY = "url";
    private static final String LOGIN_KEY = "login";
    private static final String PASSWORD_KEY = "password";
    private static final String STORE_PATH = "src/main/resources/connection.properties";

    public void configure(String ip, String port, String login, String password) throws IOException {
        Properties configureProperties = new Properties();
        configureProperties.setProperty(URL_KEY, createUrl(ip, port));
        configureProperties.setProperty(LOGIN_KEY, login);
        configureProperties.setProperty(PASSWORD_KEY, password);
        try (OutputStream storeOutStream = Files.newOutputStream(Paths.get(STORE_PATH))) {
            configureProperties.store(storeOutStream, "Added configure connection file");
            log.info("Added configure connection file");
        } catch (IOException e) {
            log.warn("Configure connection file couldn't be added", e);
            throw e;
        }
    }

    protected abstract String createUrl(String ip, String port);

}
