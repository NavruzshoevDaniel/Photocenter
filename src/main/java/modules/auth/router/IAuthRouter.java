package modules.auth.router;

import javax.swing.*;
import java.sql.Connection;

public interface IAuthRouter {
    void route(Connection connection, JFrame jFrame);
}
