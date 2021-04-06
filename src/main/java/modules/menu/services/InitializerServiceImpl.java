package modules.menu.services;


import commons.sessions.SessionFactory;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class InitializerServiceImpl implements InitializerService {
    private static final String INIT_DATA = "creationAndFilling.sql";

    @Override
    public void initPhotocenterData() throws SQLException, IOException {
        try (InputStream resource = getClass().getClassLoader().getResourceAsStream(INIT_DATA)) {
            Objects.requireNonNull(resource);
            List<String> lines = new BufferedReader(new InputStreamReader(resource,
                    StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
            try (final Statement statement = SessionFactory.getInstance().createStatement()) {
                final String initsSqlQueries = String.join("", lines);
                statement.execute(initsSqlQueries);
            }
        }
    }
}
