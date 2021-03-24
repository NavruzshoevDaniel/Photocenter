package modules.auth.service;

import java.sql.Connection;
import java.sql.SQLException;

public interface IAuthService {

    Connection login(String ip, String port, String userLogin, String password) throws SQLException;
}
