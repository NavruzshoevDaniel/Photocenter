package modules.tables.repository;

import modules.commons.sessions.ConfigureOracle;
import modules.commons.sessions.ConnectionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TablesRepositoryTest {

    @Test
    void getAllTables() throws IOException {
        final ConfigureOracle configureOracle = new ConfigureOracle();
        configureOracle.configure("84.237.50.81", "1521", "18204_Navruzshoev", "oracle");
        final TablesRepository tablesRepository = new TablesRepository();
        System.out.println(tablesRepository.getAllTables());
    }
}