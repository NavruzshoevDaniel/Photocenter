package modules.menu.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.SQLException;

public interface InitializerService {
    void initPhotocenterData() throws SQLException, IOException, URISyntaxException;
}
