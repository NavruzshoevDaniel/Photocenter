package modules.auth.service;

import java.sql.Connection;

public interface InitializerService {
    void initPhotocenterDataFor(Connection connection);
}
