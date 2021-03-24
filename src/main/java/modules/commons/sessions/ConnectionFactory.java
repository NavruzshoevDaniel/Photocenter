package modules.commons.sessions;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
public class ConnectionFactory {
    private static final String BD_CONNECTION_CONFIG = "connection.properties";
    private static final String URL = "url";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";

    private static ConnectionFactory INSTANCE = null;

    private String url;
    private String userLogin;
    private String userPassword;

    private ConnectionFactory() throws IOException {

        Properties connectionProperty = new Properties();

        connectionProperty.getProperty(BD_CONNECTION_CONFIG);
        try (InputStream propertyStream =
                     ConnectionFactory.class.getResourceAsStream(BD_CONNECTION_CONFIG)) {
            connectionProperty.load(propertyStream);
            this.url = connectionProperty.getProperty(URL);
            this.userLogin = connectionProperty.getProperty(USER_LOGIN);
            this.userPassword = connectionProperty.getProperty(USER_PASSWORD);
        } catch (IOException e) {
            log.warn(e.getMessage());
            throw e;
        }

    }

    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, userLogin, userPassword);
    }

    public ConnectionFactory getInstance() throws IOException {
        if (INSTANCE == null) {
            synchronized (ConnectionFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ConnectionFactory();
                }
            }
        }
        return INSTANCE;
    }
}
