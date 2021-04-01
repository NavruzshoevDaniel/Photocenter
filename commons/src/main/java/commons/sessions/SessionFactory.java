package commons.sessions;


import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
public class SessionFactory {
    private static Connection INSTANCE = null;

    private SessionFactory() {
    }

    public static void registerConnection(Connection connection) throws SQLException {
        if (INSTANCE == null) {
            synchronized (SessionFactory.class) {
                if (INSTANCE == null) {
                    INSTANCE = connection;
                }
            }
        }
    }


    public static Connection getInstance() {
        return INSTANCE;
    }
}
