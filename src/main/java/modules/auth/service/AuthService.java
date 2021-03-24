package modules.auth.service;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Slf4j
public class AuthService implements IAuthService {
    private static final int LOGIN_TIMEOUT = 2;

    @Override
    public Connection login(String ip, String port, String userLogin, String password) throws SQLException {
        String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":XE";
        DriverManager.setLoginTimeout(LOGIN_TIMEOUT);
        return DriverManager.getConnection(url, userLogin, password);
    }
}
